import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

public class TitlePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public TitlePanel(String x, JLabel jx, String y, JLabel jy, String z, JLabel jz) {
        super(true);
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        this.add(getUpPanel(x, jx, y, jy, z, jz), BorderLayout.CENTER);
    }

    private JPanel getUpPanel(String x, JLabel jx, String y, JLabel jy, String z, JLabel jz) {
        JPanel p1 = new JPanel(new GridLayout(1, 3, 10, 10));
        p1.setBackground(Color.white);

        jx.setText(x);
        jx.setFont(new Font("Arial", 1, 55));
        jx.setForeground(new Color(37, 174, 96));
        jx.setHorizontalAlignment(JLabel.CENTER);
        p1.add(jx, BorderLayout.WEST);

        jy.setHorizontalAlignment(JLabel.CENTER);
        jy.setText(y);
        jy.setFont(new Font("Arial", 0, 60));
        jy.setForeground(Color.red);
        p1.add(jy, BorderLayout.CENTER);

        jz.setText("更新" + z+" ");
        jz.setFont(new Font("Arial", 0, 40));
        jz.setForeground(new Color(37, 174, 96));
        jz.setHorizontalAlignment(JLabel.RIGHT);
        p1.add(jz, BorderLayout.CENTER);
        return p1;
    }


}