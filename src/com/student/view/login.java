package com.student.view;


import javax.swing.plaf.*;
import com.common.Message;
import com.student.tool.LoginOp;
import com.teacher.view.teacher1;
import net.miginfocom.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
 * Created by JFormDesigner on Sat Apr 10 12:33:01 CST 2021
 */


/**
 * @author unknown
 */
public class login extends JFrame implements ActionListener {
    public static void main(String[] args) {
        login log=new login();

        log.getContentPane().setBackground(new Color(255, 204, 204));
        log.setVisible(true);
    }
    public login() {
        initComponents();
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dispose();
        register reg=new register();
        reg.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("SDU");
        setBackground(new Color(255, 204, 204));
        setResizable(false);
        setForeground(SystemColor.windowText);
        setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 12));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "fill,hidemode 3,align center center",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[0,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[217,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[49]" +
            "[27]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[0]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("SDU\u8003\u8bd5\u5e73\u53f0\u767b\u5f55\u7cfb\u7edf");
        label1.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 37));
        contentPane.add(label1, "cell 13 5 1 3,align center center,grow 0 0");

        //---- label2 ----
        label2.setText("\u59d3\u540d");
        label2.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 20));
        contentPane.add(label2, "cell 11 9,align center center,grow 0 0");

        //---- textField1 ----
        textField1.setBackground(new Color(238, 238, 238));
        contentPane.add(textField1, "cell 13 9");

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        label3.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 20));
        contentPane.add(label3, "cell 11 11,align center center,grow 0 0");
        contentPane.add(passwordField1, "cell 13 11");

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.addActionListener(this);
        button1.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 16));
        contentPane.add(button1, "cell 13 16");

        //---- button2 ----
        button2.setText("\u6ce8\u518c");
        button2.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 16));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2, "cell 13 18");
        setSize(645, 345);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    @Override
    public void actionPerformed(ActionEvent e) {
        String uid = textField1.getText().trim();//获取输入账号
        String pwd = new String(passwordField1.getPassword());//获取密码
        //接收检验结果
        Message msg = new LoginOp().sendLoginInfoToServer(this, uid, pwd);
        System.out.println(msg);
        if (msg!=null) {
            System.out.println(msg);
            String[] info = msg.getContent().split("-");
            if(info[1].equals("2")) {
                teacher1 teacher11 = new teacher1(info[0],info[2]);
                teacher11.setVisible(true);
               /* teacher teacher11 = new teacher(info[0],info[2]);
                teacher11.setVisible(true);*/
                this.dispose();
            }
            else if(info[1].equals("1")){
                student student1=new student(info[0],info[2]);
                student1.setVisible(true);
                this.dispose();
            }
        }
    }
}
