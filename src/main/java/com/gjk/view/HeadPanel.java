package com.gjk.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class HeadPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public HeadPanel(String x, JLabel jx) {
        super(true);
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        this.add(getUpPanel(x, jx), BorderLayout.CENTER);
    }

    private JPanel getUpPanel(String x, JLabel jx) {
        JPanel p1 = new JPanel(new GridLayout(1, 1, 10, 10));
        p1.setBackground(Color.white);

        jx.setText(x);
        jx.setFont(new Font("宋体", 1, 55));
        jx.setForeground(Color.red);
        jx.setHorizontalAlignment(JLabel.CENTER);
        p1.add(jx, BorderLayout.CENTER);

        return p1;
    }


}
