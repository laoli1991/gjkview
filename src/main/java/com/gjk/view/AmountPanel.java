package com.gjk.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class AmountPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public AmountPanel(String s1, JLabel j1) {
        super(true);
        this.setBackground(Color.blue);
        this.setLayout(new BorderLayout());
        this.add(getPanel(s1, j1), BorderLayout.CENTER);
    }

    private JPanel getPanel(String s1, JLabel j1) {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.setBackground(Color.blue);
        j1.setText(s1);
        j1.setFont(new Font("宋体", 1, 100));
        j1.setForeground(Color.white);
        j1.setHorizontalAlignment(JLabel.CENTER);

//        j2.setText(s2);
//        j2.setFont(new Font("宋体", 1, 100));
//        j2.setForeground(Color.white);
//        j2.setHorizontalAlignment(JLabel.CENTER);

        panel.add(j1);
//        panel.add(j2);
        return panel;
    }


}
