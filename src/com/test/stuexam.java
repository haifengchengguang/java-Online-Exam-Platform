package com.test;

public class stuexam {
    private int testid;
    private String answer;
    private int uid;
    private int examid;
    private int examtestid;

    public void setUid1(int uid) {
        this.uid = uid;
    }

    public int getUid1() {
        return uid;
    }

    public void setExamtestid(int examtestid) {
        this.examtestid = examtestid;
    }

    public int getExamtestid() {
        return examtestid;
    }

    public int getExamid() {
        return examid;
    }

    public int getTestid() {
        return testid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }
    public stuexam(int testid,String answer,int uid,int examid,int examtestid)
    {
        this.testid=testid;
        this.answer=answer;
        this.uid=uid;
        this.examid=examid;
        this.examtestid=examtestid;
    }
    public stuexam(int uid,int examid,int examtestid)
    {
        this.uid=uid;
        this.examtestid=examtestid;
        this.examid=examid;
    }
    public stuexam(int uid,int examid)
    {
        this.uid=uid;
        //this.examtestid=examtestid;
        this.examid=examid;
    }

}
