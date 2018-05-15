package com.gjk.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class StockPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public StockPanel(String s1, JLabel j1, String s2, JLabel j2) {
        super(true);
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        this.add(getPanel(s1, j1, s2, j2), BorderLayout.CENTER);
    }

    private JPanel getPanel(String s1, JLabel j1, String s2, JLabel j2) {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.setBackground(Color.white);
        j1.setText(s1);
        j1.setFont(new Font("宋体", 0, 55));
        j1.setForeground(new Color(37, 174, 96));
        j1.setHorizontalAlignment(JLabel.CENTER);

        j2.setText(s2);
        j2.setFont(new Font("宋体", 0, 55));
        j2.setForeground(new Color(37, 174, 96));
        j2.setHorizontalAlignment(JLabel.CENTER);

        panel.add(j1);
        panel.add(j2);
        return panel;
    }


}
