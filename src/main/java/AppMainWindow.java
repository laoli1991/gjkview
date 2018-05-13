import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class AppMainWindow extends JFrame {
    private static JLabel ipResponseJLabel = new JLabel("");

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
                ClientService clientService = new ClientService();
                clientService.init();
            }
        }.start();

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            public void run() {
                String ipStr = AppUtils.getServerIp();
                if (ipStr != null) {
                    String response = AppUtils.sendMe(ipStr);
                    ipResponseJLabel.setText(response);
                }
            }
        }, 0, 10, TimeUnit.MINUTES);


    }

    public static void init() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        AppMainWindow appMainWindow = new AppMainWindow();
        appMainWindow.setTitle("金库显示系统");
        appMainWindow.getContentPane().setLayout(new BorderLayout());
        appMainWindow.setSize(new Dimension(400, 200));
        appMainWindow.setLocation(500, 200);
        appMainWindow.setVisible(true);
        appMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("服务器IP:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        JTextField ipText = new JTextField(20);
        ipText.setBounds(100, 20, 250, 30);
        String ipStr = AppUtils.getServerIp();
        if (ipStr != null) {
            ipText.setText(ipStr);
        }
        panel.add(ipText);


        JButton ipButton = new JButton("配置服务器IP");
        ipButton.setBounds(10, 60, 120, 50);
        panel.add(ipButton);

        ipResponseJLabel.setBounds(140, 60, 250, 30);
        panel.add(ipResponseJLabel);


        JButton button = new JButton("打开显示界面");
        button.setBounds(10, 110, 120, 50);
        panel.add(button);
        appMainWindow.getContentPane().add(panel, BorderLayout.CENTER);

        JkViewWindow d = new JkViewWindow();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.init(true);
            }
        });

        ipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = AppUtils.sendMe(ipText.getText());
                ipResponseJLabel.setText(response);
            }
        });
    }

}