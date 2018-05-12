import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class StatusPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public StatusPanel(String s1, JLabel j1, String s2, JLabel j2, String s3, JLabel j3, String s4, JLabel j4, String s5, JLabel j5, String s6, JLabel j6) {
        super(true);
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        this.add(getPanel(s1, j1, s2, j2, s3, j3, s4, j4, s5, j5, s6, j6), BorderLayout.CENTER);
    }

    private JPanel getPanel(String s1, JLabel j1, String s2, JLabel j2, String s3, JLabel j3, String s4, JLabel j4, String s5, JLabel j5, String s6, JLabel j6) {
        JPanel panel = new JPanel(new GridLayout(1, 5, 10, 10));
        panel.setBackground(Color.white);
        j1.setText(s1);
        j1.setFont(new Font("Arial", 0, 55));
        j1.setForeground(new Color(37, 174, 96));
        j1.setHorizontalAlignment(JLabel.CENTER);

        j2.setText(s2);
        j2.setFont(new Font("Arial", 0, 55));
        j2.setForeground(Color.BLACK);
        j2.setHorizontalAlignment(JLabel.CENTER);

        j3.setText(s3);
        j3.setFont(new Font("Arial", 0, 55));
        j3.setForeground(Color.BLACK);
        j3.setHorizontalAlignment(JLabel.CENTER);

        j4.setText(s4);
        j4.setFont(new Font("Arial", 0, 55));
        j4.setForeground(Color.BLACK);
        j4.setHorizontalAlignment(JLabel.CENTER);

        j5.setText(s5);
        j5.setFont(new Font("Arial", 0, 55));
        j5.setForeground(Color.BLACK);
        j5.setHorizontalAlignment(JLabel.CENTER);

        j6.setText(s6);
        j6.setFont(new Font("Arial", 0, 55));
        j6.setForeground(Color.BLACK);
        j6.setHorizontalAlignment(JLabel.CENTER);
        panel.add(j1);
        panel.add(j2);
        panel.add(j3);
        panel.add(j4);
        panel.add(j5);
        panel.add(j6);
        return panel;
    }


}
