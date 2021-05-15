package com.student.view;

import com.common.Message;
import com.common.MsgType;
import com.server.ManageThread;
import com.student.tool.ClientToServerThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestPlatform extends JFrame implements WindowListener {
    private String ownerId;
    public TestPlatform(String ownerId)
    {
        this.ownerId=ownerId;
        this.setTitle("\u7ebf\u4e0a\u8003\u8bd5\u5e73\u53f0\u2014\u5b66\u751f\u7aef");//线上考试平台—学生端
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
        JLabel jLabel1=new JLabel(ownerId);//用户1
        panelW.add(jLabel1);
        JTextPane jTextPane1=new JTextPane();
        jTextPane1.setEnabled(false);
        panelW.add(jTextPane1);

        /*JTextField jTextField1=new JPasswordField();
        jTextField1.setEnabled(false);
        panelW.add(jTextField1);*/
        JLabel jLabel2=new JLabel("<html><body><p align=\"center\">\u5b66\u751f\u8003\u8bd5\u5e73\u53f0<br/>v1.0.0</p></body></html>");//学生考试平台
        panelN.add(jLabel2);
        JPanel panelC=new JPanel();
        container.add(panelC,BorderLayout.CENTER);
        JPanel panelE=new JPanel();
        JLabel jLabelE=new JLabel("\u9898\u76ee");//"题目"
        panelE.add(jLabelE);
        container.add(panelE,BorderLayout.EAST);
        this.addWindowListener(this);
        //按关闭按钮，啥事也不做
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        // 设置界面可见
        this.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int option = JOptionPane.showConfirmDialog(this, "\u786e\u5b9a\u9000\u51fa\u7cfb\u7edf?", "\u63d0\u793a",
                JOptionPane.YES_NO_OPTION);//确定退出系统？ 提示
        if (option == JOptionPane.YES_OPTION)
        {
            if (e.getWindow() == this) {
                Message msg = new Message();
                msg.setSenderId(ownerId);
                msg.setType(MsgType.UNLOAD_LOGIN);
                try {
                    ClientToServerThread th = ManageThread.getThread(ownerId);
                    ObjectOutputStream out = new ObjectOutputStream(th.getClient().getOutputStream());
                    out.writeObject(msg);
                    //结束线程
                    th.myStop();
                    ManageThread.removeThread(ownerId);
                    this.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
                this.dispose();
                System.exit(0);
            } else {
                return;
            }
        }
        else if(option == JOptionPane.NO_OPTION){
            if (e.getWindow() == this) {
                return;
            }
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    /*public void paint(Graphics g){
        Font f1 = new Font("宋体", Font.BOLD, 28);
        g.setFont(f1);
        g.drawString("线上考试平台", 100, 100);

    }*/
}
