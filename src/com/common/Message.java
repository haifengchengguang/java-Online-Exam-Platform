package com.common;

import com.test.Test;

import java.io.Serializable;

/**
 * 服务器与客户端间数据以对象数据流发送
 */
public class Message implements Serializable {

    private MsgType type;//信息类型
    private String content;//信息内容
    private String getterId;//接收者
    private String senderId;//发送者
    private String sendTime;//发送时间
    private Test test;
    public Message() {
    }
    public String getSenderId() {
        return senderId;
    }

    public MsgType getType() {
        return type;
    }

    public void setType(MsgType type) {
        this.type = type;
    }

    public String getGetterId() {
        return getterId;
    }
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
    public void setGetterId(String getterId) {
        this.getterId = getterId;
    }
    public void setTest(Test test){
        this.test=test;
    }
    public Test getTest(){return test;}
    @Override
    public String toString() {
        return type + "--"+sendTime + ":" + content;
    }
}

