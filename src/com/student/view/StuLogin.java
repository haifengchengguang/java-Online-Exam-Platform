package com.student.view;

import com.common.Message;
import com.student.tool.LoginOp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StuLogin extends JFrame implements ActionListener {
    private JButton button;
    private JButton loginButton;
    private JButton loginButton1;
    private JTextField userText;
    private JPasswordField passwordText;
    public StuLogin() {
        this.setTitle("\u7ebf\u4e0a\u8003\u8bd5\u5e73\u53f0\u2014\u5b66\u751f\u767b\u5f55");//线上考试平台-学生登录
        this.setBounds(100,100,400,200);
        this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);

        /*button = new JButton("开始");
        add(button);
        button.addActionListener(this);*/
        Container container=this.getContentPane();
        container.setLayout(null);
        JLabel userLabel = new JLabel("\u7528\u6237\u540d");//用户名
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(10, 20, 80, 25);
        container.add(userLabel);

        /*
         * 创建文本域用于用户输入
         */
        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        container.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("\u5bc6\u7801");//密码
        passwordLabel.setBounds(10, 50, 80, 25);
        container.add(passwordLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        container.add(passwordText);

        //SLogin.MyButtonListener listener=new SLogin.MyButtonListener();
        // 创建登录按钮
        loginButton = new JButton("\u767b\u5f55");//登录
        loginButton.setBounds(50, 80, 80, 25);
        //loginListener listener=new loginListener();
        loginButton.addActionListener(this);
        container.add(loginButton);
        // 创建登录按钮
        loginButton1 = new JButton("\u6ce8\u518c");//注册
        loginButton1.setBounds(200, 80, 80, 25);
        loginButton1.addActionListener(this);
        container.add(loginButton1);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == loginButton1) {
            this.dispose();
            Signup signup = new Signup();
        }
        if (evt.getSource() == loginButton) {
            String privilege="1";
            String uid = userText.getText().trim();//获取输入账号
            String pwd = new String(passwordText.getPassword());//获取密码
            //接收检验结果
            Message msg = new LoginOp().sendLoginInfoToServer(this, uid, pwd);
            System.out.println(msg);
            if (msg!=null) {
                System.out.println(msg);
                TestPlatform testPlatform=new TestPlatform(uid);
                this.dispose();
            }
            }
        }


    /** Main method */
    public static void main (String[]args){
        new StuLogin();

    }


}






