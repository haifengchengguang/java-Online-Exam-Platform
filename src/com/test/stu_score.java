package com.test;

public class stu_score {
    private int selectscore;
    private int examid;
    private int uid;
    private int iiscore;
    private int stuscore;

    public void setExamid(int examid) {
        this.examid = examid;
    }

    public int getExamid() {
        return examid;
    }

    public void setUid1(int uid) {
        this.uid = uid;
    }

    public int getUid1() {
        return uid;
    }

    public int getIiscore() {
        return iiscore;
    }

    public int getSelectscore() {
        return selectscore;
    }

    public int getStuscore() {
        return stuscore;
    }

    public void setIiscore(int iiscore) {
        this.iiscore = iiscore;
    }

    public void setSelectscore(int selectscore) {
        this.selectscore = selectscore;
    }

    public void setStuscore(int stuscore) {
        this.stuscore = stuscore;
    }
    public stu_score(int selectscore,int examid,int uid,int iiscore,int stuscore)
    {
        this.stuscore=stuscore;
        this.examid=examid;
        this.selectscore=selectscore;
        this.uid=uid;
        this.iiscore=iiscore;
    }
    public stu_score(int selectscore,int examid,int uid)
    {

        this.examid=examid;
        this.selectscore=selectscore;
        this.uid=uid;

    }
    public stu_score(int examid,int uid,int iiscore,int stuscore)
    {
        this.examid=examid;
        this.uid=uid;
        this.iiscore=iiscore;
        this.stuscore=stuscore;
    }
    public stu_score(int examid,int uid)
    {
        this.examid=examid;
        this.uid=uid;
    }
    public stu_score(int uid)
    {
        this.uid=uid;
    }
}
