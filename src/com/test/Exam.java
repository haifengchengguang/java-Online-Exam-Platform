package com.test;

public class Exam {
    private int testid;
    private int examid;
    private int examtestid;
    private int time;
    private int totalscore;
    private int uid;
    private String examname;
    private  int counttest;
    public int getTestid(){return testid;}
    public void setTestid(int testid){this.testid=testid;}

    public int getExamid() {
        return examid;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public int getExamtestid() {
        return examtestid;
    }

    public void setExamtestid(int examtestid) {
        this.examtestid = examtestid;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }

    public int getUid1() {
        return uid;
    }

    public void setUid1(int uid) {
        this.uid = uid;
    }

    public int getCounttest() {
        return counttest;
    }

    public void setCounttest(int counttest) {
        this.counttest = counttest;
    }

    public Exam(int testid, int examid, int examtestid, int time, int totalscore, int uid, String examname)
    {
        this.testid=testid;
        this.examid = examid;
        this.examtestid=examtestid;
        this.time=time;
        this.totalscore=totalscore;
        this.uid=uid;
        this.examname=examname;
    }
    public Exam(int testid, int examid, int examtestid, int time, int totalscore, int uid, String examname,int counttest)
    {
        this.testid=testid;
        this.examid = examid;
        this.examtestid=examtestid;
        this.time=time;
        this.totalscore=totalscore;
        this.uid=uid;
        this.examname=examname;
        this.counttest=counttest;
    }
    public Exam(int examid,int examtestid)
    {
        this.examtestid=examtestid;
        this.examid=examid;
    }
    /*public Exam(int examid,int examtestid,int uid){
        this.examid=examid;
        this.examtestid=examtestid;
        this.uid=uid;
    }*/
    public Exam(int examid){this.examid=examid;}
    public String getExamname() {
        return examname;
    }
    public Exam(int testid, int examid,int examtestid,int time,String examname){
        this.testid=testid;
        this.examid=examid;
        this.examtestid=examtestid;
        this.time=time;
        this.examname=examname;
    }
    public void setExamname(String examname) {
        this.examname = examname;
    }
}
