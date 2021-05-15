package com.server;

import com.common.Message;
import com.common.MsgType;
import com.test.Test;
//import com.server.view.ServerFrame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 服务器与客户端通信线程
 */
public class ServerConClientThread extends Thread {
    private Message message1;
    private Socket client;
    private volatile boolean isRunning;

    public ServerConClientThread(Socket client) {
        this.client = client;
        this.isRunning = true;
    }

    public Socket getClient() {
        return client;
    }

    public void myStop(){
        isRunning = false;
    }


    @Override
    public void run() {
        try {
            while(isRunning){
                ObjectInputStream input = new ObjectInputStream(this.client.getInputStream());
                Message msg = (Message) input.readObject();
                //判断消息类型
               if(msg.getType() == MsgType.UNLOAD_LOGIN) {
                    String fromId = msg.getSenderId();
                    //结束此线程
                    myStop();
                    ManageClientThread.removeClientThread(fromId);
                    System.out.println(fromId+" 退出登录");
                    serverview.showMsg("用户"+fromId+"退出登录！");
                }
               else if(msg.getType()==MsgType.ADD_TEST){
                   System.out.println("收到"+"sendsuccess");
                   Test test=msg.getTest();
                   doaddtest(test);
               }
               else if(msg.getType()==MsgType.FIND_TEST)
               {
                   System.out.println("sendsuccess");
                   Test test=msg.getTest();
                   Test test1=daogettest(test);
                   System.out.println(test1.getAnswer());
                   msg.setType(MsgType.TEST_SERVERTOCLIENT);
                   msg.setTest(test1);
                   ObjectOutputStream objectOutputStream=new ObjectOutputStream(this.client.getOutputStream());
                   objectOutputStream.writeObject(msg);
                   setMessage1(msg);
               }
                else if(msg.getType()==MsgType.DEL_TEST)
               {
                   System.out.println("sendsuccess");
                   Test test=msg.getTest();
                   daodeltest(test);
               }
                else if(msg.getType()==MsgType.UPDATE_TEST)
               {
                   System.out.println("sendsuccess");
                   Test test=msg.getTest();
                   updatetest(test);
               }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void setMessage1(Message message1){this.message1=message1;}
    public Message getmessage1(){return message1;}
    public void doaddtest(Test test)
    {
        dao dao=new dao();
        dao.daoaddtest(test);
    }
    public Test daogettest(Test test)
    {
        dao dao=new dao();
       return dao.gettestfromdb(test);
    }
    public void daodeltest(Test test)
    {
        dao dao=new dao();
        dao.deletetest(test);
    }
    public void updatetest(Test test)
    {
        dao dao=new dao();
        dao.updatetest(test);
    }
}