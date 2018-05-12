import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.io.Files;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 * @Author: liyang117
 * @Date: 2018/5/7 19:58
 * @Description:
 */
public class AppUtils {
    public static String getLocalHostLANAddress() {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            return inetAddr.getHostAddress();
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress.getHostAddress();
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            return jdkSuppliedAddress.getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMac() {
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
        return mac;
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

    public static String sendMe(String ip) {
        try {
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");

            JSONObject js = new JSONObject();
            js.put("macAddress", AppUtils.getLocalHostLANAddress());
            js.put("ipAddress", AppUtils.getMac());
            OkHttpClient okHttpClient = new OkHttpClient();
            //创建一个RequestBody(参数1：数据类型 参数2传递的json串)
            RequestBody requestBody = RequestBody.create(JSON, js.toJSONString());
            //创建一个请求对象
            Request request = new Request.Builder()
                    .url("http://" + ip + ":8080/api/add-screen")
                    .post(requestBody)
                    .build();
            //发送请求获取响应

            Response response = okHttpClient.newCall(request).execute();
            //判断请求是否成功
            if (response.isSuccessful()) {
                //打印服务端返回结果
                String str = response.body().string();
                JSONObject rjs = com.alibaba.fastjson.JSON.parseObject(str);
                if ("1".equals(rjs.get("code"))) {
                    File file = new File(AppUtils.createIpTableIfNotExist());
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    Files.write(ip, file, Charsets.UTF_8);
                    return "连接成功！";
                }
            }
        } catch (Exception e) {
        }
        return "连接失败！";
    }

}
