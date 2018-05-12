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

    public void init() {
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
                JSONObject x = JSON.parseObject(msg);
                String a = x.getString("a");
                String A = x.getString("A");
                String b = x.getString("b");
                String B = x.getString("B");
                String c = x.getString("c");
                String C = x.getString("C");
//                String d = x.getString("d");
//                String D = x.getString("D");
//                String e = x.getString("e");
//                String E = x.getString("E");


                JLabelConfig.a.setText("  " + a);
                JLabelConfig.A.setText("  " + A);
                JLabelConfig.b.setText("  " + b);
                JLabelConfig.B.setText("  " + B);
                JLabelConfig.c.setText("  " + c);
                JLabelConfig.C.setText("  " + C);
//                JLabelConfig.d.setText("  " + d);
//                JLabelConfig.D.setText("  " + f);
//                JLabelConfig.e.setText("  " + e);
//                JLabelConfig.E.setText("  " + f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
