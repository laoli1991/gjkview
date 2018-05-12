import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AppMainWindow extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    init();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        new Thread() {
            @Override
            public void run() {
                Server server = new Server();
                server.server();
            }
        }.start();

    }

    public static void init() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
        }
        AppMainWindow appMainWindow = new AppMainWindow();
        appMainWindow.getContentPane().setLayout(null);
        appMainWindow.setSize(new Dimension(400, 200));
        appMainWindow.setLocation(500, 200);
        appMainWindow.setVisible(true);
        appMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton button = new JButton("按我");
        button.setBounds(2, 5, 80, 20);
        appMainWindow.getContentPane().add(button);
        JButton button2 = new JButton("按我2");
        button2.setBounds(40, 40, 80, 20);
        appMainWindow.getContentPane().add(button2);


        JkViewWindow d = new JkViewWindow();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.init(true);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.init(false);
            }
        });
    }

}