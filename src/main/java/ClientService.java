import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: liyang117
 * @Date: 2018/4/25 15:15
 * @Description:
 */
public class ClientService {

    public ClientService() {
    }

    public void server() {
        try {
            DatagramSocket socket = new DatagramSocket(9002);
            while (true) {
                byte[] buf = new byte[65600];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                byte[] data = packet.getData();
                String msg = new String(data, 0, packet.getLength(), "UTF-8");
                System.out.println(msg);
                System.out.println(msg.getBytes("UTF-8").length);
//                JSONObject x = JSON.parseObject(msg);
//                String a = x.getString("a");
//                String b = x.getString("b");
//                String c = x.getString("c");
//                String d = x.getString("d");
//                String e = x.getString("e");
//                String f = x.getString("f");
//
//                JLabelConfig.a.setText("  " + a);
//                JLabelConfig.b.setText("  " + b);
//                JLabelConfig.c.setText("  " + c);
//                JLabelConfig.d.setText("  " + d);
//                JLabelConfig.e.setText("  " + e);
//                JLabelConfig.f.setText("  " + f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
