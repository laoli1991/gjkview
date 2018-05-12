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

        JPanel titelPanel = new JPanel(new GridLayout(1, 1, 10, 10));
        titelPanel.add(new TitlePanel("纸100元（05版)", new JLabel(), "完整劵", new JLabel(), "2018-05-06 15:03", new JLabel()));
        container.add(titelPanel, BorderLayout.NORTH);


        JPanel mainPanel = new JPanel(new GridLayout(1, 1, 10, 10));
        JPanel leftPanel = new JPanel(new GridLayout(6, 1, 10, 10));

        JPanel j1 = new StatusPanel(
                "", new JLabel(),
                "箱", new JLabel(),
                "捆", new JLabel(),
                "把", new JLabel(),
                "合计", new JLabel(),
                "金额", new JLabel());
        leftPanel.add(j1);

        JPanel j2 = new StatusPanel(
                "原封劵", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel());
        leftPanel.add(j2);

        JPanel j3 = new StatusPanel(
                "已清分", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel());
        leftPanel.add(j3);


        JPanel j4 = new StatusPanel(
                "未清分", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel());
        leftPanel.add(j4);


        JPanel j5 = new StatusPanel(
                "已复点", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel());
        leftPanel.add(j5);


        JPanel j6 = new StatusPanel(
                "未复点", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel(),
                "X", new JLabel());
        leftPanel.add(j6);


        JPanel rightPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        mainPanel.add(leftPanel);
        //  mainPanel.add(rightPanel);


        //在面板中添加按钮


        container.add(mainPanel, BorderLayout.CENTER);

//        container.add(new StatusPanel("类别", JLabelConfig.h, "", JLabelConfig.a));
//        container.add(new StatusPanel("B", JLabelConfig.i, "纸100元（05版）", new JLabel()));
//        container.add(new StatusPanel("B", JLabelConfig.i, "b", JLabelConfig.b));
//        container.add(new StatusPanel("B", JLabelConfig.i, "b", JLabelConfig.b));
//        container.add(new StatusPanel("B", JLabelConfig.i, "b", JLabelConfig.b));
//        container.add(new StatusPanel("B", JLabelConfig.i, "b", JLabelConfig.b));
//        container.add(new StatusPanel("C", JLabelConfig.j, "c", JLabelConfig.c));
//        container.add(new StatusPanel("D", JLabelConfig.k, "d", JLabelConfig.d));
//        container.add(new StatusPanel("E", JLabelConfig.l, "e", JLabelConfig.e));
//        container.add(new StatusPanel("F", JLabelConfig.m, "f", JLabelConfig.f));
//
//        container.add(new StatusPanel("E", JLabelConfig.l, "e", JLabelConfig.e));
//        container.add(new StatusPanel("F", JLabelConfig.m, "f", JLabelConfig.f));
//        container.add(new StatusPanel("E", JLabelConfig.l, "e", JLabelConfig.e));
//        container.add(new StatusPanel("F", JLabelConfig.m, "f", JLabelConfig.f));
//        container.add(new StatusPanel("E", JLabelConfig.l, "e", JLabelConfig.e));
//        container.add(new StatusPanel("F", JLabelConfig.m, "f", JLabelConfig.f));
//        container.add(new StatusPanel("E", JLabelConfig.l, "e", JLabelConfig.e));
//        container.add(new StatusPanel("F", JLabelConfig.m, "f", JLabelConfig.f));
    }

}
