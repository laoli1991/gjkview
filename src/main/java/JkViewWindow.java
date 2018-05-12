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
        frame.setTitle("GJK");
        frame.setBackground(Color.WHITE);
        frame.setUndecorated(false);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d.width, d.height);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        JPanel hPanel = new JPanel(new GridLayout(1, 1, 10, 10));
        hPanel.add(new HeadPanel(" 欢迎罗总视察指导工作 ", new JLabel()));
        container.add(hPanel, BorderLayout.NORTH);


        JPanel mainPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        JPanel titelPanel = new JPanel(new GridLayout(1, 1, 10, 10));
        titelPanel.add(new TitlePanel("纸100元（05版)", new JLabel(), "完整劵（原封卷）", new JLabel(), "2018-05-06 15:03", new JLabel()));

        mainPanel.add(titelPanel);

        JPanel j1 = new StockPanel(
                "X", JLabelConfig.a,
                "箱", JLabelConfig.A);
        mainPanel.add(j1);

        JPanel j2 = new StockPanel(
                "X", JLabelConfig.b,
                "捆", JLabelConfig.B);
        mainPanel.add(j2);

        JPanel j3 = new StockPanel(
                "金额", JLabelConfig.c,
                "100万元", JLabelConfig.C);
        mainPanel.add(j3);


        container.add(mainPanel, BorderLayout.CENTER);

    }

}
