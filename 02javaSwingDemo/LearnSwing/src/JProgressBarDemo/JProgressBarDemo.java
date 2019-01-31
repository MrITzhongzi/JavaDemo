package JProgressBarDemo;

import com.sun.javaws.progress.Progress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JProgressBarDemo extends JFrame {
    public JProgressBarDemo(){
        setTitle("使用进度条");
        JLabel label = new JLabel("欢迎使用在线升级功能！");

        JProgressBar jProgressBar = new JProgressBar();
        JButton button = new JButton("完成");
        button.setEnabled(false);
        Container container = getContentPane();
        container.setLayout(new GridLayout(3,1));
         JPanel panel1  = new JPanel(new FlowLayout(FlowLayout.LEFT));
         JPanel panel2  = new JPanel(new FlowLayout(FlowLayout.CENTER));
         JPanel panel3  = new JPanel(new FlowLayout(FlowLayout.RIGHT));

         panel1.add(label);
         panel2.add(jProgressBar);
         panel3.add(button);

         container.add(panel1);
         container.add(panel2);
         container.add(panel3);

         jProgressBar.setStringPainted(true);
         jProgressBar.setString("升级进行中……");

         new Progress(jProgressBar, button).start();

         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 disable();
                 System.exit(0);
             }
         });
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        JProgressBarDemo frame=new JProgressBarDemo();
        //frame.setBounds(300,200,300,150);    //设置容器的大小
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
    private class Progress extends Thread
    {
        JProgressBar progressBar;
        JButton button;
        //进度条上的数字
        int[] progressValues={6,18,27,39,51,66,81,100};
        Progress(JProgressBar progressBar,JButton button)
        {
            this.progressBar=progressBar;
            this.button=button;
        }
        public void run()
        {
            for(int i=0;i<progressValues.length;i++)
            {
                try
                {
                    Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                //设置进度条的值
                progressBar.setValue(progressValues[i]);
            }
            progressBar.setIndeterminate(false);
            progressBar.setString("升级完成！");
            button.setEnabled(true);
        }
    }
}


