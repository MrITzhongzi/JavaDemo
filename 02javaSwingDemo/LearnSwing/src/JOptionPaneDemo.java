import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JOptionPaneDemo {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame("对话框展示");
        jFrame.setSize(300, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setBounds(300,200,300,400);
        jFrame.setVisible(true);
//        showConfirmDialogDemo(jFrame);
//        showMessageDialogDemo(jFrame);
        showOptionDialogDemo(jFrame);
    }

    public static void showConfirmDialogDemo(JFrame jFrame){
        int msg = JOptionPane.showConfirmDialog(jFrame, "确定要删除吗？", "删除提示", 0);
        Container contentPane = jFrame.getContentPane();
        JPanel jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5,5,5,5));
        jPanel.setSize(new Dimension(300,300));
        JLabel jLabel = new JLabel(Integer.toString(msg));
        jPanel.add(jLabel);
        contentPane.add(jPanel);
    }

    public static void showMessageDialogDemo(JFrame jFrame){
        JOptionPane.showMessageDialog(jFrame,"你知道了么？", "小提示", 0);

    }

    public static void showOptionDialogDemo(JFrame jFrame){
        JButton[] bs={new JButton("确定"),new JButton("取消"),new JButton("重置")};
        int i = JOptionPane.showOptionDialog(jFrame, "请选择其中一项", "选择", 1, 3, null, bs, bs[0]);

    }
}
