import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SwingWidget {
    public static void main(String[] args) {
//        jFrameDemo();
//        jPannelDemo();
//        borderLayoutDemo();
//        flowLayoutDemo();
//        cardLayoutDemo();
//        gridLayoutDemo();
//        gridBagLayoutDemo();
//        boxLayoutDemo();
//        jLabelDemo();
//        jButton();
//        jTestFieldDemo();
//        jTextArea();
//        jCheckBox();
//        jRadio();
//        jcomboBoxDemo();

//        jListDemo1();
//        jListDemo2();

//        JFrame jFrame = new CalclateLayout();
//        jFrame.setVisible(true);

//        ActionListenerDemo frame=new ActionListenerDemo();
//        frame.setVisible(true);

//        FocusListenerDemo frame = new FocusListenerDemo();
//        frame.setVisible(true);

        jSliderDemo();
    }

    public static void jFrameDemo(){
        JFrame jFrame = new JFrame("java 第一个GUi程序");
        jFrame.setSize(400, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocation(400, 400);

        JLabel jlabel = new JLabel("这是使用JFrame类创建的窗口");
        Container contentPane = jFrame.getContentPane();
        contentPane.add(jlabel);

        jFrame.setVisible(true);
    }

    public static void jPannelDemo(){
        JFrame jf = new JFrame("第二个GUI程序");
        jf.setBounds(300,100,400,200);

        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel("这是放在panel上的标签");

        jPanel.setBackground(Color.white);
        jPanel.add(jLabel);
        jf.add(jPanel);

        jf.setVisible(true);
    }

    public static void borderLayoutDemo() {
        JFrame frame=new JFrame("Java第三个GUI程序");    //创建Frame窗口
        frame.setSize(400,200);
        frame.setLayout(new BorderLayout(10,3));    //为Frame窗口设置布局为BorderLayout
        JButton button1=new JButton ("上");
        JButton button2=new JButton("左");
        JButton button3=new JButton("中");
        JButton button4=new JButton("右");
        JButton button5=new JButton("下");
        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.WEST);
        frame.add(button3,BorderLayout.CENTER);
        frame.add(button4,BorderLayout.EAST);
        frame.add(button5,BorderLayout.SOUTH);
        frame.setBounds(300,200,600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void flowLayoutDemo(){
        JFrame jFrame=new JFrame("Java第四个GUI程序");    //创建Frame窗口
        JPanel jPanel=new JPanel();    //创建面板
        JButton btn1=new JButton("1");    //创建按钮
        JButton btn2=new JButton("2");
        JButton btn3=new JButton("3");
        JButton btn4=new JButton("4");
        JButton btn5=new JButton("5");
        JButton btn6=new JButton("6");
        JButton btn7=new JButton("7");
        JButton btn8=new JButton("8");
        JButton btn9=new JButton("9");
        jPanel.add(btn1);    //面板中添加按钮
        jPanel.add(btn2);
        jPanel.add(btn3);
        jPanel.add(btn4);
        jPanel.add(btn5);
        jPanel.add(btn6);
        jPanel.add(btn7);
        jPanel.add(btn8);
        jPanel.add(btn9);
        //向JPanel添加FlowLayout布局管理器，将组件间的横向和纵向间隙都设置为20像素
        jPanel.setLayout(new FlowLayout( FlowLayout.LEADING,20,20));
        jPanel.setBackground(Color.gray);    //设置背景色
        jFrame.add(jPanel);    //添加面板到容器
        jFrame.setBounds(300,200,300,150);    //设置容器的大小
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void cardLayoutDemo(){

        JFrame frame=new JFrame("Java第五个程序");    //创建Frame窗口
        JPanel p1=new JPanel();    //面板1
        JPanel p2=new JPanel();    //面板2
        JPanel cards=new JPanel(new CardLayout());    //卡片式布局的面板
        p1.add(new JButton("登录按钮"));
        p1.add(new JButton("注册按钮"));
        p1.add(new JButton("找回密码按钮"));
        p2.add(new JTextField("用户名文本框",20));
        p2.add(new JTextField("密码文本框",20));
        p2.add(new JTextField("验证码文本框",20));
        cards.add(p1,"card1");    //向卡片式布局面板中添加面板1
        cards.add(p2,"card2");    //向卡片式布局面板中添加面板2
        CardLayout cl=(CardLayout)(cards.getLayout());
        cl.show(cards,"card2");    //调用show()方法显示面板2
        frame.add(cards);
        frame.setBounds(300,200,400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void gridLayoutDemo(){
        JFrame frame=new JFrame("GridLayou布局计算器");
        JPanel panel=new JPanel();    //创建面板
        //指定面板的布局为GridLayout，4行4列，间隙为5
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.add(new JButton("7"));    //添加按钮
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("/"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("*"));
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("-"));
        panel.add(new JButton("0"));
        panel.add(new JButton("."));
        panel.add(new JButton("="));
        panel.add(new JButton("+"));
        frame.add(panel);    //添加面板到容器
        frame.setBounds(300,200,200,150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void gridBagLayoutDemo(){
        JFrame frame=new JFrame("拨号盘");
        GridBagLayout gbaglayout=new GridBagLayout();    //创建GridBagLayout布局管理器
        GridBagConstraints constraints=new GridBagConstraints();
        frame.setLayout(gbaglayout);    //使用GridBagLayout布局管理器
        constraints.fill=GridBagConstraints.BOTH;    //组件填充显示区域
        constraints.weightx=0.0;    //恢复默认值
        constraints.gridwidth = GridBagConstraints.REMAINDER;    //结束行
        JTextField tf=new JTextField("13612345678");
        gbaglayout.setConstraints(tf, constraints);
        frame.add(tf);
        constraints.weightx=0.5;    // 指定组件的分配区域
        constraints.weighty=0.2;
        constraints.gridwidth=1; // 组件显示区域 水平/竖直方向 所占单元格的个数，默认值为 1
        makeButton("7",frame,gbaglayout,constraints);    //调用方法，添加按钮组件
        makeButton("8",frame,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;    //结束行
        makeButton("9",frame,gbaglayout,constraints);
        constraints.gridwidth=1;    //重新设置gridwidth的值

        makeButton("4",frame,gbaglayout,constraints);
        makeButton("5",frame,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        makeButton("6",frame,gbaglayout,constraints);
        constraints.gridwidth=1;

        makeButton("1",frame,gbaglayout,constraints);
        makeButton("2",frame,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        makeButton("3",frame,gbaglayout,constraints);
        constraints.gridwidth=1;

        makeButton("返回",frame,gbaglayout,constraints);
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        makeButton("拨号",frame,gbaglayout,constraints);
        constraints.gridwidth=1;
        frame.setBounds(400,400,400,400);    //设置容器大小
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //向JFrame中添加JButton按钮
    public static void makeButton(String title,JFrame frame,GridBagLayout gridBagLayout,GridBagConstraints constraints) {
        JButton button=new JButton(title);    //创建Button对象
        gridBagLayout.setConstraints(button,constraints);
        frame.add(button);
    }

    public static void boxLayoutDemo(){
        JFrame frame=new JFrame("Java示例程序");
        Box b1=Box.createHorizontalBox();    //创建横向Box容器
        Box b2=Box.createVerticalBox();    //创建纵向Box容器
        frame.add(b1);    //将外层横向Box添加进窗体
        b1.add(Box.createVerticalStrut(200));    //添加高度为200的垂直框架
        b1.add(new JButton("西"));    //添加按钮1
        b1.add(Box.createHorizontalStrut(140));    //添加长度为140的水平框架
        b1.add(new JButton("东"));    //添加按钮2
        b1.add(Box.createHorizontalGlue());    //添加水平胶水
        b1.add(b2);    //添加嵌套的纵向Box容器
        //添加宽度为100，高度为20的固定区域
        b2.add(Box.createRigidArea(new Dimension(100,20)));
        b2.add(new JButton("北"));    //添加按钮3
        b2.add(Box.createVerticalGlue());    //添加垂直组件
        b2.add(new JButton("南"));    //添加按钮4
        b2.add(Box.createVerticalStrut(40));    //添加长度为40的垂直框架
        //设置窗口的关闭动作、标题、大小位置以及可见性等
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,400,200);
        frame.setVisible(true);
    }

    public static void jLabelDemo(){
        JFrame frame=new JFrame("Java标签组件示例");    //创建Frame窗口
        JPanel jp=new JPanel();    //创建面板
        JLabel label1=new JLabel("普通标签");    //创建标签
        JLabel label2=new JLabel();
        label2.setText("调用setText()方法");
        ImageIcon img=new ImageIcon("./src/image/qq.png");    //创建一个图标
        //创建既含有文本又含有图标的JLabel对象
        JLabel label3=new JLabel("开始理财",img,JLabel.CENTER);
        jp.add(label1);    //添加标签到面板
        jp.add(label2);
        jp.add(label3);
        frame.add(jp);
        frame.setBounds(300,200,400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void jButton(){
        JFrame frame=new JFrame("Java按钮组件示例");    //创建Frame窗口
        frame.setSize(400, 200);
        JPanel jp=new JPanel();    //创建JPanel对象
        JButton btn1=new JButton("我是普通按钮");    //创建JButton对象
        JButton btn2=new JButton("我是带背景颜色按钮");
        JButton btn3=new JButton("我是不可用按钮");
        JButton btn4=new JButton("我是底部对齐按钮");
        jp.add(btn1);
        btn2.setBackground(Color.YELLOW);    //设置按钮背景色
        jp.add(btn2);
        btn3.setEnabled(false);    //设置按钮不可用
        jp.add(btn3);
        Dimension preferredSize=new Dimension(160, 60);    //设置尺寸
        btn4.setPreferredSize(preferredSize);    //设置按钮大小
        btn4.setVerticalAlignment(SwingConstants.BOTTOM);    //设置按钮垂直对齐方式
        jp.add(btn4);
        frame.add(jp);
        frame.setBounds(300, 200, 600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void jTestFieldDemo(){
        JFrame frame=new JFrame("Java文本框组件示例");    //创建Frame窗口
        JPanel jp=new JPanel();    //创建面板
        JTextField txtfield1=new JTextField();    //创建文本框
        txtfield1.setText("普通文本框");    //设置文本框的内容
        JTextField txtfield2=new JTextField(28);
        txtfield2.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        txtfield2.setText("指定长度和字体的文本框");
        JTextField txtfield3=new JTextField(30);
        txtfield3.setText("居中对齐");
        txtfield3.setHorizontalAlignment(JTextField.CENTER);    //居中对齐
        jp.add(txtfield1);
        jp.add(txtfield2);
        jp.add(txtfield3);
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void jTextArea(){
        JFrame frame=new JFrame("Java文本域组件示例");    //创建Frame窗口
        JPanel jp=new JPanel();    //创建一个JPanel对象
        JTextArea jta=new JTextArea("请输入内容",7,30);
        jta.setLineWrap(true);    //设置文本域中的文本为自动换行
        jta.setForeground(Color.red);    //设置组件的背景色
        jta.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        jta.setBackground(Color.YELLOW);    //设置按钮背景色
        JScrollPane jsp=new JScrollPane(jta);    //将文本域放入滚动窗口
        Dimension size=jta.getPreferredSize();    //获得文本域的首选大小
        jsp.setBounds(110,90,size.width,size.height);
        jp.add(jsp);    //将JScrollPane添加到JPanel容器中
        frame.add(jp);    //将JPanel容器添加到JFrame容器中
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setSize(400,200);    //设置JFrame容器的大小
        frame.setVisible(true);
    }

    public static void jCheckBox(){
        JFrame frame=new JFrame("Java复选组件示例");    //创建Frame窗口
        JPanel jp=new JPanel();    //创建面板
        JLabel label=new JLabel("流行编程语言有：");
        label.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        JCheckBox chkbox1=new JCheckBox("C#", true);    //创建指定文本和状态的复选框
        JCheckBox chkbox2=new JCheckBox("C++");    //创建指定文本的复选框
        JCheckBox chkbox3=new JCheckBox("Java");    //创建指定文本的复选框
        JCheckBox chkbox4=new JCheckBox("Python");    //创建指定文本的复选框
        JCheckBox chkbox5=new JCheckBox("PHP");    //创建指定文本的复选框
        JCheckBox chkbox6=new JCheckBox("Perl");    //创建指定文本的复选框
        jp.add(label);
        jp.add(chkbox1);
        jp.add(chkbox2);
        jp.add(chkbox3);
        jp.add(chkbox4);
        jp.add(chkbox5);
        jp.add(chkbox6);
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void jRadio(){
        JFrame frame=new JFrame("Java单选组件示例");    //创建Frame窗口
        JPanel panel=new JPanel();    //创建面板
        JLabel label1=new JLabel("现在是哪个季节：");
        JRadioButton rb1=new JRadioButton("春天");    //创建JRadioButton对象
        JRadioButton rb2=new JRadioButton("夏天");    //创建JRadioButton对象
        JRadioButton rb3=new JRadioButton("秋天",true);    //创建JRadioButton对象
        JRadioButton rb4=new JRadioButton("冬天");    //创建JRadioButton对象
        label1.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        ButtonGroup group=new ButtonGroup();
        //添加JRadioButton到ButtonGroup中
        group.add(rb1);
        group.add(rb2);
        panel.add(label1);
        panel.add(rb1);
        panel.add(rb2);
        group.add(rb3);
        group.add(rb4);
        panel.add(rb3);
        panel.add(rb4);
        frame.add(panel);
        frame.setBounds(300, 200, 400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /***
     * 下拉列表组件
     */
    public static void jcomboBoxDemo(){
        JFrame frame=new JFrame("Java下拉列表组件示例");
        JPanel jp=new JPanel();    //创建面板
        JLabel label1=new JLabel("证件类型：");    //创建标签
        JComboBox cmb=new JComboBox();    //创建JComboBox
        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem("身份证");
        cmb.addItem("驾驶证");
        cmb.addItem("军官证");
        jp.add(label1);
        jp.add(cmb);
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /***
     * 列表框组件
     * */
    public static void jListDemo1(){
        JFrame frame=new JFrame("Java列表框组件示例");
        JPanel jp=new JPanel();    //创建面板
        JLabel label1=new JLabel("证件类型：");    //创建标签
        String[] items=new String[]{"身份证","驾驶证","军官证"};
        JList list=new JList(items);    //创建JList
        jp.add(label1);
        jp.add(list);
        frame.add(jp);
        frame.setBounds(300,200,400,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void jListDemo2(){
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Java列表框组件示例");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置窗体退出时操作
        jFrame.setBounds(100,100,300,200);    //设置窗体位置和大小
        JPanel contentPane=new JPanel();    //创建内容面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));    //设置面板的边框
        contentPane.setLayout(new BorderLayout(0, 0));    //设置内容面板为边界布局
        jFrame.setContentPane(contentPane);    //应用内容面板
        JScrollPane scrollPane=new JScrollPane();    //创建滚动面板
        contentPane.add(scrollPane,BorderLayout.CENTER);    //将面板增加到边界布局中央
        JList list=new JList();
        //限制只能选择一个元素
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);    //在滚动面板中显示列表
        String[] listData=new String[12];    //创建一个含有12个元素的数组
        for (int i=0;i<listData.length;i++)
        {
            listData[i]="这是列表框的第"+(i+1)+"个元素~";    //为数组中各个元素赋值
        }
        list.setListData(listData);    //为列表填充数据

        jFrame.setVisible(true);
    }

    /***
     * 滑块组件
     * */
    public static void jSliderDemo(){
        JFrame frame=new JFrame("滑块组件示例");
        frame.setSize(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane=frame.getContentPane();
        JSlider slider=new JSlider(0,100);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        contentPane.add(slider);
        frame.setVisible(true);
    }
}
