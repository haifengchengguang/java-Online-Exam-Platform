package com.test;

import java.io.Serializable;

public class Test implements Serializable {
    private int testid;//题目编号
    private int score;//分数
    private int difficulty;//难度
    private String question;//题目
    private int qustiontype;
    private String answer;
    private String selectanswer;
    private int counttest;
    public int getTestid(){return testid;}
    public void setTestid(int testid){this.testid=testid;}
    public int getScore()
    {
        return score;
    }
    public void setScore(int score)
    {
        this.score=score;
    }
    public int getDifficulty()
    {
        return difficulty;
    }
    public void setDifficulty(int difficulty)
    {
        this.difficulty=difficulty;
    }
    public String getQuestion()
    {
        return question;
    }
    public void setQuestion(String question)
    {
        this.question = question;
    }
    public int getQustiontype(){return qustiontype;}
    public void setQustiontype(int qustiontype){this.qustiontype=qustiontype;}
    public String getAnswer(){return answer;}
    public void setAnswer(String answer){this.answer=answer;}



    /*public Test(int testid, int score, int difficulty, String question, char selectanswer, int qustiontype){//选择
                this.difficulty=difficulty;
                this.qustiontype=qustiontype;
                this.question=question;
                this.testid=testid;
                this.score=score;
                this.selectanswer=selectanswer;
            }*/
    public Test(int testid, int score, int difficulty, String question, String answer, int qustiontype){//填空、简答
        this.difficulty=difficulty;
        this.qustiontype=qustiontype;
        this.question=question;
        this.testid=testid;
        this.score=score;
        this.answer=answer;
    }

    public Test(int testid)
    {
        this.testid=testid;
    }
}
