import com.alibaba.fastjson.JSONObject;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author: liyang117
 * @Date: 2018/4/25 15:14
 * @Description:
 */
public class Client {

    public static void send(String text) {
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] buf = text.getBytes("UTF-8");
            System.out.println(buf.length);
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.235.1"), 9002);
            socket.send(packet);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100000;i++){
            try {
                JSONObject x = new JSONObject();
                x.put("a", i % 2 == 0 ? "100纸币" : "50纸币");
                x.put("b", i % 2 == 0 ? "捆" : "打");
                x.put("c", i);
                x.put("d", i % 2 == 0 ? "XX":"YY");
                x.put("e", i % 2 == 0 ? "入库" : "出库");
                x.put("f", System.nanoTime());

                String text = x.toJSONString();
                send(text);
            } catch (Exception e) {

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
