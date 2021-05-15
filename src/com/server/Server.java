package com.server;

import com.common.Message;
import com.common.MsgType;
import com.common.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    private ServerSocket serverSocket;
    private Socket client;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private volatile boolean isRunning;

    public Server(){
            System.out.println("---------------Server(9999)---------------");
            isRunning = true;
            new Thread(this).start();
        }

        /**
         * 结束线程运行
         */
        public void myStop() {
            isRunning = false;
            close(serverSocket);
        }

    @Override
    public void run() {
        try {
            //1.设置服务器套接字 ServerSocket(int port)创建绑定到指定端口的服务器套接字
            serverSocket = new ServerSocket(9999);
            while(isRunning) {
                //2.阻塞式等待客户端连接  (返回值)Socket accept()侦听要连接到此套接字的客户端并接受它。
                client = serverSocket.accept();
                System.out.println("\u4e00\u4e2a\u5ba2\u6237\u7aef\u5df2\u8fde\u63a5"+"....");//一个客户端已连接
                input = new ObjectInputStream(client.getInputStream());
                output = new ObjectOutputStream(client.getOutputStream());
                User u = (User)input.readObject();
                System.out.println(u.toString());
                if(u.getUoption().equals("1"))
                doUserLogin(u);
                else doUserRegister(u);
            }
        } catch (IOException e) {
            close(output,input,client,serverSocket);//释放资源
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void doUserRegister(User u) {
            Message msg=new Message();
            dao daocheck=new dao();
            if(null==ManageClientThread.getClientThread(u.getUid()))//不在线
            {
                String name=daocheck.checkUserInfo(u);
                if (null!=name){//已注册
                    msg.setType(MsgType.ALREADY_REGIST);
                    try {
                        output.writeObject(msg);
                        close(output,input,client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else //未注册
                    {
                    String user=daocheck.daoRegister(u);
                    if(null!=user)
                    {
                    msg.setType(MsgType.REGISTER_SUCCEED);
                    msg.setContent(name);
                        try {
                            output.writeObject(msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        serverview.showMsg("\u7528\u6237"+u.getUid()+"\u6ce8\u518c\u6210\u529f");//用户xx注册成功
                    }
                    }

            }
            else try {
                msg.setType(MsgType.ALREADY_LOGIN);
                output.writeObject(msg);
                close(output,input,client);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void doUserLogin(User u){
        Message msg = new Message();

        dao daocheck=new dao();
        //该用户未登录
        if(null == ManageClientThread.getClientThread(u.getUid())){
            try{
                String name = daocheck.checkUserInfo(u);
                if(null != name){//登录成功
                    msg.setType(MsgType.LOGIN_SUCCEED);
                    //这里需要查询数据库返回用户信息，现在msg是空的!!!!!!!!!!!!!!!!!!!!!!!!!!!,现在不是空的了
                    msg.setContent(name);
                    output.writeObject(msg);
                    //客户端连接成功就为其创建线程保持与服务器端通讯
                    ServerConClientThread th = new ServerConClientThread(client);
                    th.start();
                    //将其添加到线程集合
                    ManageClientThread.addClientThread(u.getUid(),th);


                    serverview.showMsg("\u7528\u6237"+u.getUid()+"\u6210\u529f\u767b\u5f55\uff01");//用户xx成功登录
                }else{
                    msg.setType(MsgType.LOGIN_FAILED);
                    output.writeObject(msg);
                    close(output,input,client);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{//该用户已登录
            try {
                msg.setType(MsgType.ALREADY_LOGIN);
                output.writeObject(msg);
                close(output,input,client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 用于关闭多个io流
     * @param ios
     */
    private void close(Closeable... ios) {//可变长参数
        for(Closeable io: ios) {
            try {
                if(null != io)
                    io.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
