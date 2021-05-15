package com.server;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * 管理所有与客户端的线程
 */
public class ManageClientThread {

    private static Hashtable<String, com.server.ServerConClientThread> threads = new Hashtable<>();

    public static Hashtable<String, com.server.ServerConClientThread> getClientThreads() {
        return threads;
    }

    public static void addClientThread(String uid, com.server.ServerConClientThread thread){
        threads.put(uid,thread);
    }

    public static com.server.ServerConClientThread getClientThread(String uid){
        return threads.get(uid);
    }

    public static void removeClientThread(String uid){
        threads.remove(uid);
    }

    /**
     * 返回当前在线全部用户
     * @return
     */
    public static String getOnLineList(){
        StringBuilder sb = new StringBuilder();
        Iterator it = threads.keySet().iterator();
        while(it.hasNext()){
            sb.append(it.next()+" ");
        }
        return sb.toString();
    }
}
