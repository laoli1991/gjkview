package com.gjk.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JkViewWindow {
    private JFrame frame;

    public void init(boolean vis) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame.setVisible(vis);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JkViewWindow() {
        initialize();
    }

    private void initialize() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
        }

        frame = new JFrame();
        frame.setTitle("金库显示系统");
        frame.setBackground(Color.blue);
        frame.setUndecorated(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d.width, d.height);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(5, 1, 0, 0));

        JPanel titelPanel = new JPanel(new GridLayout(1, 1, 10, 10));
        titelPanel.add(new TitlePanel(
                AppUtils.formtStr(ConfigStaticDatas.msgDtoBegin.getVoucherName()), ConfigStaticDatas.voucherName));

        mainPanel.add(titelPanel);

        JPanel titelPane2 = new JPanel(new GridLayout(1, 1, 10, 10));
        titelPane2.add(new TitlePanel(
                AppUtils.formtStr(ConfigStaticDatas.msgDtoBegin.getTypeDesc()), ConfigStaticDatas.typeDesc));

        mainPanel.add(titelPane2);

        JPanel j1 = new StockPanel(
                AppUtils.formtStr(ConfigStaticDatas.msgDtoBegin.getKey1()), ConfigStaticDatas.key1,
                AppUtils.formtStr(ConfigStaticDatas.msgDtoBegin.getValue1()), ConfigStaticDatas.value1);
        mainPanel.add(j1);

        JPanel j2 = new StockPanel(
                AppUtils.formtStr(ConfigStaticDatas.msgDtoBegin.getKey2()), ConfigStaticDatas.key2,
                AppUtils.formtStr(ConfigStaticDatas.msgDtoBegin.getValue2()), ConfigStaticDatas.value2);
        mainPanel.add(j2);

        JPanel j3 = new AmountPanel(
                AppUtils.formtStr(ConfigStaticDatas.msgDtoBegin.getAmount()), ConfigStaticDatas.amount);
        mainPanel.add(j3);


        container.add(mainPanel, BorderLayout.CENTER);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    init(false);
                }
            }
        });

    }

}
