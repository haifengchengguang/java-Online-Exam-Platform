package com.student.tool;

import com.common.Message;
import com.common.MsgType;
import com.common.User;
import com.server.ManageThread;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.regex.Pattern;

public class RegisterOp {
    private Socket client;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public RegisterOp() {
        try {
            client = new Socket("localhost", 9999);
            output = new ObjectOutputStream(client.getOutputStream());
            input = new ObjectInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("\u8fde\u63a5\u670d\u52a1\u5668\u5931\u8d25\uff01");//连接服务器失败
            e.printStackTrace();
        }
    }

    /**
     * 检测用户输入信息是否合理
     * 合理则将登录信息封存到对象中返回
     * 不合理则显示提示信息
     *
     * @param f
     * @param uid
     * @param pwd
     * @return
     */
    private User checkLoginInfo(JFrame f, String uid, String pwd,String privilege,String name) {
        User u = null;
        if (!uid.equals("") && !pwd.equals("")) {
            String pattern = "[0-9]{3,10}";//账号为1-10位数字
            if (Pattern.matches(pattern, uid)) {//账号合法
                u = new User(uid, pwd,"2",privilege,name);
            } else {//账号不合法
                JOptionPane.showMessageDialog(f, "\u8d26\u53f7\u4e3a3\u523010\u4f4d\u6570\u5b57\u5e8f\u5217\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01");//"账号为3到10位数字序列，请重新输入！"
            }
        } else if (uid.equals("")) {//账号为空
            JOptionPane.showMessageDialog(f, "\u8bf7\u8f93\u5165\u8d26\u53f7\uff01");//"请输入账号！"
        } else if (pwd.equals("")) {//密码为空
            JOptionPane.showMessageDialog(f,"\u8bf7\u8f93\u5165\u5bc6\u7801\uff01" );//"请输入密码！"
        }
        return u;
    }

    /**
     * 将通过校验的登录信息发送到服务器
     * 并将得到的消息包返回(包含当前用户的所有好友)
     *
     * @param f
     * @param uid
     * @param pwd
     */

    public Message sendRegisterInfoToServer(JFrame f, String uid, String pwd,String privilege,String name) {
        User u = checkLoginInfo(f, uid, pwd,privilege,name);
        if (u != null) {
            try {
                output.writeObject(u);//发送到服务器
                System.out.println("ok " + u.toString());
                Message msg = (Message) input.readObject();//接收返回结果
                if (msg.getType() == MsgType.REGISTER_SUCCEED) {//登录成功
                    return msg;
                }
                else if (msg.getType()==MsgType.ALREADY_REGIST){
                    JOptionPane.showMessageDialog(f,"\u8be5\u7528\u6237\u5df2\u6ce8\u518c");//该用户已注册
                }
                else if (msg.getType() == MsgType.REGISTER_FAILED) {
                    JOptionPane.showMessageDialog(f,"\u8d26\u53f7\u6216\u5bc6\u7801\u8f93\u5165\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\uff01" );//"账号或密码输入错误，请重新输入！"
                } else if (msg.getType() == MsgType.ALREADY_LOGIN) {
                    JOptionPane.showMessageDialog(f, "\u8be5\u7528\u6237\u5df2\u767b\u5f55\uff0c\u8bf7\u52ff\u91cd\u590d\u64cd\u4f5c\uff01");//"该用户已登录，请勿重复操作！"
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
