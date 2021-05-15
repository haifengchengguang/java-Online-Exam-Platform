package com.student.view;

import javax.swing.plaf.*;
import com.common.Message;
import com.student.tool.RegisterOp;
import net.miginfocom.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
 * Created by JFormDesigner on Sun Apr 11 21:48:35 CST 2021
 */


/**
 * @author Brainrain
 */
public class register extends JFrame {
    public register() {
        initComponents();
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        frame2.dispose();
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        frame1.dispose();
        this.dispose();
        login log=new login();
        log.getContentPane().setBackground(new Color(255, 204, 204));
        log.setVisible(true);
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        String privilege="1";
        String name=textField2.getText().trim();
        String uid = textField1.getText().trim();//获取输入账号
        String pwd = new String(passwordField1.getPassword());//获取密码
        String pwd2= new String(passwordField2.getPassword());
        if(pwd.equals(pwd2))
        {
            Message msg = new RegisterOp().sendRegisterInfoToServer(this, uid, pwd,privilege,name);
            if (msg!=null) {frame1.setVisible(true);}
        }
        else
        {
            JOptionPane.showMessageDialog(this,"\u4e24\u6b21\u8f93\u5165\u7684\u5bc6\u7801\u4e0d\u4e00\u81f4","\u9519\u8bef",0);
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        String verify=textField3.getText();

        String privilege="2";
        String name=textField2.getText().trim();
        String uid = textField1.getText().trim();//获取输入账号
        String pwd = new String(passwordField1.getPassword());//获取密码
        String pwd2= new String(passwordField2.getPassword());
        if(pwd.equals(pwd2))
        {
            if (verify.equals("8888")) {
                Message msg = new RegisterOp().sendRegisterInfoToServer(this, uid, pwd, privilege, name);
                if (msg != null) {
                    frame1.setVisible(true);
                }
            }
            else JOptionPane.showMessageDialog(this,"\u9a8c\u8bc1\u7801\u9519\u8bef","\u9519\u8bef",0);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"\u4e24\u6b21\u8f93\u5165\u7684\u5bc6\u7801\u4e0d\u4e00\u81f4","\u9519\u8bef",0);
        }
        // TODO add your code here

        //frame2.setVisible(true);
    }

    private void button5MouseClicked(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        login log=new login();
        log.getContentPane().setBackground(new Color(255, 204, 204));
        log.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label4 = new JLabel();
        label1 = new JLabel();
        textField2 = new JTextField();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        label5 = new JLabel();
        passwordField2 = new JPasswordField();
        label8 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();
        button5 = new JButton();
        button2 = new JButton();
        frame1 = new JFrame();
        label6 = new JLabel();
        button3 = new JButton();
        frame2 = new JFrame();
        label7 = new JLabel();
        button4 = new JButton();

        //======== this ========
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
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
            "[]"));

        //---- label4 ----
        label4.setText("SDU\u8003\u8bd5\u5e73\u53f0\u6ce8\u518c\u7cfb\u7edf");
        label4.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 37));
        contentPane.add(label4, "cell 9 2");

        //---- label1 ----
        label1.setText("\u59d3\u540d");
        label1.setFont(new Font("\u5b8b\u4f53", label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 7));
        contentPane.add(label1, "cell 7 3,align center center,grow 0 0");
        contentPane.add(textField2, "cell 9 3");

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d");
        label2.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 20));
        contentPane.add(label2, "cell 7 4,align center center,grow 0 0");
        contentPane.add(textField1, "cell 9 4");

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        label3.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 20));
        contentPane.add(label3, "cell 7 5,align center center,grow 0 0");
        contentPane.add(passwordField1, "cell 9 5");

        //---- label5 ----
        label5.setText("\u91cd\u590d\u5bc6\u7801");
        label5.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 20));
        contentPane.add(label5, "cell 7 6,align center center,grow 0 0");
        contentPane.add(passwordField2, "cell 9 6");

        //---- label8 ----
        label8.setText("\u6559\u5e08\u9a8c\u8bc1\u7801");
        label8.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 19));
        contentPane.add(label8, "cell 7 8");
        contentPane.add(textField3, "cell 9 8");

        //---- button1 ----
        button1.setText("\u6559\u5e08\u6ce8\u518c");
        button1.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 16));
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 9 8");

        //---- button5 ----
        button5.setText("\u8fd4\u56de");
        button5.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 16));
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button5MouseClicked(e);
            }
        });
        contentPane.add(button5, "cell 7 9");

        //---- button2 ----
        button2.setText("\u5b66\u751f\u6ce8\u518c");
        button2.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 16));
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2, "cell 9 9");
        setSize(645, 345);
        setLocationRelativeTo(null);

        //======== frame1 ========
        {
            frame1.setResizable(false);
            frame1.setAlwaysOnTop(true);
            var frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[fill]" +
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
                "[]"));

            //---- label6 ----
            label6.setText("\u6ce8\u518c\u6210\u529f\uff01");
            label6.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 20));
            frame1ContentPane.add(label6, "cell 3 2,align center center,grow 0 0");

            //---- button3 ----
            button3.setText("\u767b\u5f55");
            button3.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 16));
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });
            frame1ContentPane.add(button3, "cell 3 3");
            frame1.setSize(310, 115);
            frame1.setLocationRelativeTo(frame1.getOwner());
        }

        //======== frame2 ========
        {
            frame2.setResizable(false);
            frame2.setAlwaysOnTop(true);
            var frame2ContentPane = frame2.getContentPane();
            frame2ContentPane.setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //---- label7 ----
            label7.setText("\u6ce8\u518c\u5931\u8d25\uff01\u8bf7\u52ff\u91cd\u590d\u6ce8\u518c");
            label7.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 20));
            frame2ContentPane.add(label7, "cell 2 1,align center center,grow 0 0");

            //---- button4 ----
            button4.setText("\u5173\u95ed");
            button4.setFont(new Font("\u672c\u58a8\u9648\u9ed1", Font.PLAIN, 16));
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                }
            });
            frame2ContentPane.add(button4, "cell 2 2");
            frame2.setSize(310, 115);
            frame2.setLocationRelativeTo(frame2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label4;
    private JLabel label1;
    private JTextField textField2;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JLabel label5;
    private JPasswordField passwordField2;
    private JLabel label8;
    private JTextField textField3;
    private JButton button1;
    private JButton button5;
    private JButton button2;
    private JFrame frame1;
    private JLabel label6;
    private JButton button3;
    private JFrame frame2;
    private JLabel label7;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
