package com.common;


/**
 * 用户信息类
 */
public class User implements java.io.Serializable {
    //标识登录注册
    private String uoption;//1登录，2注册
    private String uname;
    private String uid;
    private String pwd;
    private String privilege;

    public String getUname(){return uname;}

    public void setUname(String uname){this.uname=uname;}

    public String getPrivilege(){return privilege;}

    public void setPrivilege(String privilege){this.privilege=privilege;}

    public String getUoption(){return uoption;}

    public void setUoption(String uoption){this.uoption=uoption;}

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(String uid, String pwd,String uoption) {
        this.uid = uid;
        this.pwd = pwd;
        this.uoption=uoption;
    }
    public User(String uid, String pwd,String uoption,String privilege) {
        this.uid = uid;
        this.pwd = pwd;
        this.uoption=uoption;
        this.privilege=privilege;
    }
    public User(String uid, String pwd,String uoption,String privilege,String uname) {
        this.uid = uid;
        this.pwd = pwd;
        this.uoption=uoption;
        this.privilege=privilege;
        this.uname=uname;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", privilege='" + privilege + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}

