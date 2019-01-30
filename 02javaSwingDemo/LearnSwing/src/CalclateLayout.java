import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CalclateLayout extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    public CalclateLayout(){
        setTitle("计算器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,250,200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);

        JPanel panel1 = new JPanel();
        contentPane.add(panel1, BorderLayout.NORTH);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        panel1.add(textField);
        textField.setColumns(18);

        addBtn();
    }

    public void addBtn(){
        JPanel panel2=new JPanel();    //新建面板用于保存按钮

        panel2.setLayout(new GridLayout(4,4,5,5));    //面板使用网格4X4布局
        JButton button01=new JButton("7");    //新建按钮
        panel2.add(button01);    //应用按钮
        JButton button02=new JButton("8");    //新建按钮
        panel2.add(button02);    //应用按钮
        JButton button03=new JButton("9");    //新建按钮
        panel2.add(button03);    //应用按钮
        JButton button04=new JButton("+");    //新建按钮
        panel2.add(button04);    //应用按钮
        JButton button05=new JButton("4");    //新建按钮
        panel2.add(button05);    //应用按钮
        JButton button06=new JButton("5");    //新建按钮
        panel2.add(button06);    //应用按钮
        JButton button07=new JButton("6");    //新建按钮
        panel2.add(button07);    //应用按钮
        JButton button08=new JButton("-");    //新建按钮
        panel2.add(button08);    //应用按钮
        JButton button09=new JButton("3");    //新建按钮
        panel2.add(button09);    //应用按钮
        JButton button10=new JButton("2");    //新建按钮
        panel2.add(button10);    //应用按钮
        JButton button11=new JButton("1");    //新建按钮
        panel2.add(button11);    //应用按钮
        JButton button12=new JButton("*");    //新建按钮
        panel2.add(button12);    //应用按钮
        JButton button13=new JButton("0");    //新建按钮
        panel2.add(button13);    //应用按钮
        JButton button14=new JButton(".");    //新建按钮
        panel2.add(button14);    //应用按钮
        JButton button15=new JButton("=");    //新建按钮
        panel2.add(button15);    //应用按钮
        JButton button16=new JButton("/");    //新建按钮
        panel2.add(button16);    //应用按钮

        contentPane.add(panel2, BorderLayout.CENTER);    //将面板放置在边界布局的中央
    }

}
