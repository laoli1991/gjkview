package com.gjk.view;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.io.Files;
import com.google.common.primitives.Ints;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 * @Author: liyang117
 * @Date: 2018/5/7 19:58
 * @Description:
 */
public class AppUtils {

    public static String getMacAddress(Integer port) {
        String mac = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            byte[] macs = ni.getHardwareAddress();
            Formatter formatter = new Formatter();
            for (int i = 0; i < macs.length; i++) {
                mac = formatter.format(Locale.getDefault(), "%02X%s", macs[i], i < macs.length - 1 ? "-" : "").toString();
            }
        } catch (Exception e) {
        }
        return mac + ":" + port;
    }

    public static String createIpTableIfNotExist() {
        String dir = System.getProperty("user.dir") + File.separator + "datas";
        File folder = new File(dir);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String path = dir + File.separator + "ip.txt";
        return path;
    }

    public static String getServerIp() {
        String ipStr = null;
        File file = new File(AppUtils.createIpTableIfNotExist());
        try {
            List<String> lines = Files.readLines(file, Charsets.UTF_8);
            ipStr = Joiner.on("").skipNulls().join(lines);
        } catch (IOException e) {
        }
        return ipStr;
    }

    public static String sendMe(String ip, Integer fresh, Integer port) {
        try {
            AddScreenRequest addScreenRequest = new AddScreenRequest();
            addScreenRequest.setMacAddress(getMacAddress(port));
            addScreenRequest.setFresh(fresh);
            addScreenRequest.setPort(port);
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"),
                    JSONObject.toJSONString(addScreenRequest));
            Request request = new Request.Builder()
                    .url("http://" + ip + ":8080/api/add-screen")
                    .post(requestBody)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                AddScreenReponse addScreenReponse = JSONObject.parseObject(response.body().string(), AddScreenReponse.class);
                if (addScreenReponse.getCode() == 1) {
                    if (fresh == 1) {
                        MsgDto msgDto = addScreenReponse.getMsgDto();
                        if (msgDto != null) {
                            ConfigStaticDatas.freshJLabels(msgDto);
                        }
                    }
                    File file = new File(AppUtils.createIpTableIfNotExist());
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    Files.write(ip, file, Charsets.UTF_8);
                    return "连接成功！本机IP：" + addScreenReponse.getIpAddress();
                }
            }
        } catch (Exception e) {
        }
        return "连接失败！";
    }

    public static String formtStr(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

}
