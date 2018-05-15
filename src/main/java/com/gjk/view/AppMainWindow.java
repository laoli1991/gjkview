package com.gjk.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class AppMainWindow extends JFrame {
    private static JLabel ipResponseJLabel = new JLabel("");

    public static void main(String[] args) throws Exception {
        final DatagramSocket socket = new DatagramSocket();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    init(socket.getLocalPort());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        new Thread() {
            @Override
            public void run() {
                ClientService clientService = new ClientService(socket);
                clientService.init();
            }
        }.start();

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            public void run() {
                String ipStr = AppUtils.getServerIp();
                if (ipStr != null) {
                    String response = AppUtils.sendMe(ipStr, 0, socket.getLocalPort());
                    ipResponseJLabel.setText(response);
                }
            }
        }, 5, 10, TimeUnit.MINUTES);
    }

    public static void init(int port) {
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

        JLabel macAddressAndPortLable = new JLabel("Mac地址:端口"+AppUtils.getMacAddress(port));
        macAddressAndPortLable.setBounds(10, 0, 300, 25);
        panel.add(macAddressAndPortLable);

        JLabel userLabel = new JLabel("服务器IP:");
        userLabel.setBounds(10, 25, 80, 25);
        panel.add(userLabel);
        JTextField ipText = new JTextField(20);
        ipText.setBounds(100, 25, 250, 30);
        String ipStr = AppUtils.getServerIp();
        if (ipStr != null) {
            ipText.setText(ipStr);
        }
        panel.add(ipText);


        JButton ipButton = new JButton("配置服务器IP");
        ipButton.setBounds(10, 65, 120, 50);
        panel.add(ipButton);

        ipResponseJLabel.setBounds(140, 65, 250, 30);
        panel.add(ipResponseJLabel);


        JButton button = new JButton("打开显示界面");
        button.setBounds(10, 115, 120, 50);
        panel.add(button);
        appMainWindow.getContentPane().add(panel, BorderLayout.CENTER);

        JkViewWindow d = new JkViewWindow();

        if (ipStr != null) {
            String response = AppUtils.sendMe(ipStr, 1, port);
            ipResponseJLabel.setText(response);
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.init(true);
            }
        });

        ipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String response = AppUtils.sendMe(ipText.getText(), 1, port);
                ipResponseJLabel.setText(response);
            }
        });
    }

}