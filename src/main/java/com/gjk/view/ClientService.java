package com.gjk.view;

import com.alibaba.fastjson.JSONObject;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: liyang117
 * @Date: 2018/4/25 15:15
 * @Description:
 */
public class ClientService {
    private DatagramSocket socket;

    public ClientService(DatagramSocket socket) {
        this.socket = socket;
    }

    public void init() {
        try {
            while (true) {
                byte[] buf = new byte[65600];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                byte[] data = packet.getData();
                String msg = new String(data, 0, packet.getLength(), "UTF-8");
                System.out.println(msg);
                MsgDto msgDto = JSONObject.parseObject(msg, MsgDto.class);
                if (msgDto != null) {
                    ConfigStaticDatas.amount.setText(AppUtils.formtStr(msgDto.getAmount()));
                    ConfigStaticDatas.commonInfo.setText(AppUtils.formtStr(msgDto.getCommonInfo()));
                    ConfigStaticDatas.key1.setText(AppUtils.formtStr(msgDto.getKey1()));
                    ConfigStaticDatas.key2.setText(AppUtils.formtStr(msgDto.getKey2()));
                    ConfigStaticDatas.nowTime.setText(AppUtils.formtStr(msgDto.getNowTime()) + "更新");
                    ConfigStaticDatas.typeDesc.setText(AppUtils.formtStr(msgDto.getTypeDesc()));
                    ConfigStaticDatas.value1.setText(AppUtils.formtStr(msgDto.getValue1()));
                    ConfigStaticDatas.value2.setText(AppUtils.formtStr(msgDto.getValue2()));
                    ConfigStaticDatas.voucherName.setText(AppUtils.formtStr(msgDto.getVoucherName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
