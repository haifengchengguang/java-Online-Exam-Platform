package com.student.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    private JButton signupButton;
    private JButton loginButton;
    /*public static void main(String[] arg){
        new Signup();
    }*/
    public Signup(){
        this.setTitle("线上考试学生注册");
        this.setBounds(100,100,400,200);
        this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

        /*
         * 调用用户定义的方法并添加组件到面板
         */
        this.setSize(400, 200);

        /*button = new JButton("开始");
        add(button);
        button.addActionListener(this);*/
        Container container=this.getContentPane();
        container.setLayout(null);
        JLabel userLabel = new JLabel("用户名");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(10, 20, 80, 25);
        container.add(userLabel);

        /*
         * 创建文本域用于用户输入
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        container.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("密码");
        passwordLabel.setBounds(10, 50, 80, 25);
        container.add(passwordLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        container.add(passwordText);
        JLabel passwordLabel1 = new JLabel("确认密码");
        passwordLabel1.setBounds(10, 80, 80, 25);
        container.add(passwordLabel1);
        JPasswordField passwordText1 = new JPasswordField(20);
        passwordText1.setBounds(100, 80, 165, 25);
        container.add(passwordText1);

        //SLogin.MyButtonListener listener=new SLogin.MyButtonListener();
        // 创建登录按钮
        loginButton = new JButton("登录");
        loginButton.setBounds(50, 110, 80, 25);
        loginButton.addActionListener(this);
        container.add(loginButton);
        // 创建注册按钮
        signupButton = new JButton("注册");
        signupButton.setBounds(200, 110, 80, 25);
        //signupButton.addActionListener(this);
        container.add(signupButton);




        // 设置界面可见
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == loginButton) {
            this.dispose();
            StuLogin stuLogin =new StuLogin();
        }
    }
}
