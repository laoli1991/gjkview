import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author: liyang117
 * @Date: 2018/5/15 09:57
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket();
                System.out.println(datagramSocket.getPort());
                datagramSocket = new DatagramSocket();
                System.out.println(datagramSocket.getPort());
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }
}
