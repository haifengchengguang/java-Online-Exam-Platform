package com.student.tool;


import com.common.Message;
import com.common.MsgType;
import com.server.ManageThread;
import com.server.dao;
import com.test.Test;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 客户端与服务器通信线程
 */
public class ClientToServerThread extends Thread{

    private Socket client;
    private volatile boolean isRunning;

    public ClientToServerThread(Socket client){
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
                if(msg.getType() == MsgType.SERVER_CLOSE){
                    String toId = msg.getGetterId();
                    //自动下线
                    System.out.println("logout");
                    ManageThread.removeThread(toId);

                }
                else if(msg.getType()==MsgType.TEST_SERVERTOCLIENT)
                {
                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(ManageThread.getThread(msg.getGetterId()).client.getOutputStream());
                    objectOutputStream.writeObject(msg);
                    System.out.println("to success");

                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
