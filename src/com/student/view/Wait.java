package com.student.view;

import javax.swing.*;
import java.awt.*;

public class Wait extends JFrame{

public Wait()
    {
        this.setTitle("线上考试平台—学生端");
        this.setBounds(100,100,350,200);
        //this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        this.setSize(1000, 600);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        Container container=this.getContentPane();
        container.setLayout(new BorderLayout());
        JPanel panelW=new JPanel();
        container.add(panelW, BorderLayout.WEST);
        JPanel panelN=new JPanel();
        container.add(panelN,BorderLayout.NORTH);
        JLabel jLabel1=new JLabel("用户1");
        panelW.add(jLabel1);
        JTextPane jTextPane1=new JTextPane();
        jTextPane1.setEnabled(false);
        panelW.add(jTextPane1);

        /*JTextField jTextField1=new JPasswordField();
        jTextField1.setEnabled(false);
        panelW.add(jTextField1);*/
        JLabel jLabel2=new JLabel("<html><body><p align=\"center\">学生考试平台<br/>v1.0.0</p></body></html>");
        panelN.add(jLabel2);
        JPanel panelC=new JPanel();
        container.add(panelC,BorderLayout.CENTER);
        JPanel panelE=new JPanel();
        JLabel jLabelE=new JLabel("题目");
        panelE.add(jLabelE);
        container.add(panelE,BorderLayout.EAST);


        // 设置界面可见
        this.setVisible(true);
    }
    /*public void paint(Graphics g){
        Font f1 = new Font("宋体", Font.BOLD, 28);
        g.setFont(f1);
        g.drawString("线上考试平台", 100, 100);

    }*/
}
