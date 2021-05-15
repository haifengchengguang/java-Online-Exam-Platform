package com.server;

import com.common.User;
import com.server.Util;
import com.test.Exam;
import com.test.Test;
import com.test.stu_score;
import com.test.stuexam;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class dao {
    Util util;
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt = null;
    public String checkUserInfo(User u){
        util=new Util();
        Connection con= util.getConnection();
        String username = null;
        int uid = Integer.parseInt(u.getUid());
        String pwd = u.getPwd();
        String sql = "select uname,privilege from  t_user where uid=? and pwd=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,uid);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            while (rs.next()){
                username = rs.getString("uname")+"-"+rs.getString("privilege")+"-"+uid;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            release(con,ps,rs);
        }
        return username;
    }
    public String daoRegister(User u){
        util=new Util();
        Connection con= util.getConnection();
        String username = u.getUname();
        String uid = u.getUid();
        String pwd = u.getPwd();
        String privil=u.getPrivilege();

        String sql="insert into t_user (uid,pwd,uname,privilege) values(?,?,?,?)";
        try
        {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }
        catch (SQLException e1)
        {
            e1.printStackTrace();
        }
        try
        {

                try
                {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, uid);
                    ps.setString(2, pwd);

                    ps.setString(3, username);
                    ps.setString(4,privil );

                    ps.executeUpdate();
                    //JOptionPane.showMessageDialog(this, "添加成功");
                }
                catch (SQLException e)
                {
                     e.printStackTrace();
                    //JOptionPane.showMessageDialog(this, "添加失败");
                }
                finally
                {
                    try
                    {
                        if (ps != null)
                            ps.close();
                        con.close();
                    }
                    catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
            }


        catch (NumberFormatException | HeadlessException e)
        {
            e.printStackTrace();
        }

        return u.toString();
    }
    public String getuname(String uid)
    {
        String uname = null;
        util=new Util();
        Connection con= util.getConnection();
        String sql="select uname from t_user where uid=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,uid);
            rs=ps.executeQuery();
            while (rs.next())
            {
                uname=rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
        return uname;
    }
    public String[] getstu()
    {
        ArrayList list=new ArrayList();
        String[] strings = new String[0];
        util=new Util();
        Connection con= util.getConnection();
        String sql="select uid from t_user where privilege='1'";
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();
            while (rs.next())
            {
                for (int i = 1; i <= columnCount; i++) {

                    list.add(rs.getInt(i));
                }

            }
            strings=new String[list.size()];
            for (int j=0;j<list.size();j++)
            {
                strings[j]= list.get(j).toString();
                System.out.println(list.get(j));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
        return strings;
    }
    public void daoaddtest(Test test)
    {
        util=new Util();
        Connection con= util.getConnection();
        int testid=test.getTestid();
        int score=test.getScore();
        int difficult=test.getDifficulty();
        String question=test.getQuestion();
        String answer=test.getAnswer();
        int questiontype=test.getQustiontype();
        String sql="insert into t_test (testid,score,difficult,question,answer,questiontype) values(?,?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,testid);
            ps.setInt(2,score);
            ps.setInt(3,difficult);
            ps.setString(4,question);
            ps.setString(5,answer);
            ps.setInt(6,questiontype);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
    }

    public ArrayList gettestidfromdb()
    {
        ArrayList list=new ArrayList();
        util=new Util();
        Connection connection= util.getConnection();
        String sql="select testid from t_test";
        try {
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();

            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();
            System.out.println("columnCount="+columnCount);
            while (rs.next()) {



                for (int i = 1; i <= columnCount; i++) {

                    list.add(rs.getInt(i));
                }



            }
            for (int j=0;j<list.size();j++)
            {
                System.out.println(list.get(j));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return list;
    }
    public ArrayList gettestidfromdb(int examid)
    {

        ArrayList list=new ArrayList();
        util=new Util();
        Connection connection= util.getConnection();
        String sql="select testid from exampaper where examid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,examid);
            rs=ps.executeQuery();

            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();

            while (rs.next()) {



                for (int i = 1; i <= columnCount; i++) {

                    list.add(rs.getInt(i));
                }



            }
            for (int j=0;j<list.size();j++)
            {
                System.out.println(list.get(j));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return list;
    }

    public int getmaxtestid()
    {
        util=new Util();
        int maxtestid = 0;
        Connection connection= util.getConnection();
        String sql="select max(testid) from t_test";
        try {
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next())
            {
                maxtestid=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return maxtestid;
    }
    public Test gettestfromdb(Test test)
    {
        int score=0;
        int difficult=0;
        String question=null;
        String answer=null;
        int questiontype=0;
        util=new Util();
        Connection con= util.getConnection();
        int testid=test.getTestid();
        Test test1=null;
        String sql="select testid,score,difficult,question,answer,answer,questiontype from t_test where testid=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,testid);
            rs=ps.executeQuery();
            while (rs.next()){
            testid=Integer.parseInt(rs.getString(1));
            score= Integer.parseInt(rs.getString(2));
            difficult= Integer.parseInt(rs.getString(3));
            question=rs.getString(4);
            answer=rs.getString(5);
            String strqstype=rs.getString("questiontype");
                System.out.println(strqstype);
            questiontype= Integer.parseInt(strqstype);}
            test1=new Test(testid,score,difficult,question,answer,questiontype);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }

        return test1;
    }
    public void deletetest(Test test)
    {
        util=new Util();
        Connection con= util.getConnection();
        int testid=test.getTestid();
        String sql="delete from t_test where testid="+testid;
        try {
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
    }

    public void updatetest(Test test)
    {
        util=new Util();
        Connection connection= util.getConnection();
        int testid=test.getTestid();
        int score=test.getScore();
        int difficult=test.getDifficulty();
        String question=test.getQuestion();
        String answer=test.getAnswer();

        int questiontype=test.getQustiontype();
        String sql="update t_test set score=?,difficult=?,question=?,answer=? where testid="+testid;
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,score);
            ps.setInt(2,difficult);
            ps.setString(3,question);
            ps.setString(4,answer);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
    }
    public String daogetexamname(int examid){
        String examname = null;
        util=new Util();
        Connection connection= util.getConnection();
        String sql="select distinct examname from exampaper where examid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,examid);
            rs=ps.executeQuery();
            while (rs.next())
            {
                examname=rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return examname;
    }
    public void daosetexam(Exam exam){
        util=new Util();
        Connection connection= util.getConnection();
        int examid=exam.getExamid();
        int examtestid=exam.getExamtestid();
        int testid=exam.getTestid();
        String sql="insert into exampaper (testid,examid,examtestid) values (?,?,?)";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,testid);
            ps.setInt(2,examid);
            ps.setInt(3,examtestid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
    }
    public void daoupdateExam(int examid,String examname,int time)
    {
        util=new Util();
        Connection connection= util.getConnection();
        String sql="update exampaper set examname=?,time=? where examid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setString(1,examname);
            ps.setInt(2,time);
            ps.setInt(3,examid);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
    }
    public void daodelExam(Exam exam){
        util=new Util();
        Connection connection= util.getConnection();
        int examid=exam.getExamid();
        int examtestid=exam.getExamtestid();

        String sql="delete from exampaper where examid=? and examtestid=?";
        try {
            ps=connection.prepareStatement(sql);

            ps.setInt(1,examid);
            ps.setInt(2,examtestid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
    }
    public void daodelsub1Exam(Exam exam)
    {
        util=new Util();
        Connection connection= util.getConnection();;
        int examid=exam.getExamid();
        int examtestid=exam.getExamtestid();
        //int testid=exam.getExamtestid();
        String sql="update exampaper set examtestid=examtestid-1 where examid=? and examtestid=?";
        try {
            ps=connection.prepareStatement(sql);
            //ps.setInt(1,testid);
            ps.setInt(1,examid);
            ps.setInt(2,examtestid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
    }
    public ArrayList daogetexam()
    {
        ArrayList list=new ArrayList();
        util=new Util();
        Connection connection=util.getConnection();
        String sql="select distinct examid from exampaper";
        try {
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();

            while (rs.next()) {



                for (int i = 1; i <= columnCount; i++) {

                    list.add(rs.getInt(i));
                }



            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return list;
    }
    public  String[] daogetexamid1()
    {
        ArrayList arrayList=new ArrayList();
        String[] str = new String[0];
        util=new Util();
        Connection con= util.getConnection();
        String sql="select distinct examid from exampaper";
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();
            System.out.println("columnCount="+columnCount);
            while (rs.next())
            {
                for (int i = 1; i <= columnCount; i++) {

                    arrayList.add(rs.getInt(i));
                }
            }
            str=new String[arrayList.size()];
            for (int j=0;j<arrayList.size();j++)
            {
                System.out.println(arrayList.get(j));
                str[j]=arrayList.get(j).toString();
            }
            System.out.println("strlenth"+str.length);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
        return str;
    }
    public  String[] daogetexamid()
    {
        ArrayList arrayList=new ArrayList();
        String[] str = new String[0];
        util=new Util();
        Connection con= util.getConnection();
        String sql="select distinct examid from stuexam";
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();

            while (rs.next())
            {
                for (int i = 1; i <= columnCount; i++)
                {
                    arrayList.add(rs.getInt(i));
                }
            }
            str=new String[arrayList.size()];
            for (int j=0;j<arrayList.size();j++)
            {
                System.out.println(arrayList.get(j));
                str[j]=arrayList.get(j).toString();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
        return str;
    }
    public ArrayList daogetexmid()
    {
        ArrayList list = new ArrayList();
        util=new Util();
        Connection con= util.getConnection();
        String sql="select examid from stuexam";
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();

            while (rs.next()) {



                for (int i = 1; i <= columnCount; i++) {

                    list.add(rs.getInt(i));
                }



            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
        return list;
    }
    public int daogetmaxexamtestid(Exam exam)
    {
        int maxtestid=0;
        util=new Util();
        Connection con= util.getConnection();
        int examid=exam.getExamid();
        String sql="select MAX(examtestid) from exampaper where examid=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,examid);
            rs=ps.executeQuery();
            while (rs.next())
            {
                maxtestid=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
        return maxtestid;
    }
    public Exam daogetExam1(Exam exam){
        util=new Util();
        Connection con= util.getConnection();
        int examid=exam.getExamid();
        int uid=exam.getUid1();
        int examtestid=exam.getExamtestid();
        System.out.println(uid+" dao uid");
        System.out.println(examtestid+" dao eamtestid");
        int testid;
        int totalscore;
        int time;
        int counttest;
        String examname;
        Exam exam1=null;
        String sql="select testid,examid,examtestid,time,examname from exampaper where examid=?";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,examid);
            rs=ps.executeQuery();
            while (rs.next()) {
                testid = rs.getInt("testid");
                examid = rs.getInt("examid");
                examtestid = rs.getInt("examtestid");
                time = rs.getInt("time");

                examname = rs.getString("examname");

                exam1 = new Exam(testid, examid, examtestid, time, examname);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
        return exam1;

    }
    public Exam daogetExam(Exam exam){
        util=new Util();
        Connection con= util.getConnection();
        int examid=exam.getExamid();

        int examtestid=exam.getExamtestid();
        //System.out.println(uid+" dao uid");
        System.out.println(examtestid+" dao eamtestid");
        int testid;
        int totalscore;
        int time;
        int counttest;
        String examname;
        Exam exam1=null;
        String sql="select testid,examid,examtestid,time,examname from exampaper where examid=? and examtestid=?";
        try {
            System.out.println("in sql");
            ps=con.prepareStatement(sql);
            ps.setInt(1,examid);
            System.out.println("in sql2");
            ps.setInt(2,examtestid);
            rs=ps.executeQuery();
            System.out.println("in sql4");
            /*while (rs.next()) {
                System.out.println("in sql3");
                testid = rs.getInt("testid");
                examid = rs.getInt("examid");
                examtestid = rs.getInt("examtestid");
                time = rs.getInt("time");
                //totalscore = rs.getInt("totalscore");
                examname = rs.getString("examname");
                System.out.println("testid="+testid);
                exam1 = new Exam(testid, examid, examtestid, time, examname);

            }*/
            while (rs.next()) {
                testid = rs.getInt("testid");
                examid = rs.getInt("examid");
                examtestid = rs.getInt("examtestid");
                time = rs.getInt("time");

                examname = rs.getString("examname");

                exam1 = new Exam(testid, examid, examtestid, time, examname);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
        return exam1;

    }
    public void setstuexam(stuexam stuexam)
    {
        util=new Util();
        Connection con= util.getConnection();
        int testid=stuexam.getTestid();
        String answer=stuexam.getAnswer();
        int uid=stuexam.getUid1();
        int examid=stuexam.getExamid();
        int examtestid=stuexam.getExamtestid();
        String sql="insert into stuexam (testid,answer,uid,examid,examtestid) values (?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,testid);
            ps.setString(2,answer);
            ps.setInt(3,uid);
            ps.setInt(4,examid);
            ps.setInt(5,examtestid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
    }
    public String[] getstuexamuid(int examid)
    {
        ArrayList arrayList=new ArrayList();
        String[] strings = new String[0];
        util=new Util();
        Connection connection= util.getConnection();
        String sql="select distinct uid from stuexam where examid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,examid);
            rs=ps.executeQuery();

            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();
            //strings=new String[columnCount];
            while (rs.next())
            {
                for (int i = 1; i <= columnCount; i++){
                    arrayList.add(rs.getInt(i));
                }
            }
            strings=new String[arrayList.size()];
            for (int j=0;j<arrayList.size();j++)
            {
                System.out.println(arrayList.get(j));
                strings[j]=arrayList.get(j).toString();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return strings;
    }
    public ArrayList getstuexam(int examid)
    {
        ArrayList list=new ArrayList();
        util=new Util();
        Connection connection= util.getConnection();
        String sql="select uid from stuexam where examid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,examid);
            rs=ps.executeQuery();

            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();

            while (rs.next()) {



                for (int i = 1; i <= columnCount; i++) {

                    list.add(rs.getInt(i));
                }



            }
            for (int j=0;j<list.size();j++)
            {
                System.out.println(list.get(j));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return list;
    }
    public stuexam techgetstuexam(stuexam stuexam)
    {
        stuexam stuexam1=null;
        util=new Util();
        Connection connection= util.getConnection();
        int uid=stuexam.getUid1();
        int examid=stuexam.getExamid();
        int examtestid = 0;
        //int examtestid=stuexam.getExamtestid();
        int testid=0;
        String answer=null;
        String sql="select testid, answer,Min(examtestid) from stuexam where uid=? and examid=? and testid not in (select testid from t_test where questiontype=1)";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,uid);
            ps.setInt(2,examid);
            //ps.setInt(3,examtestid);
            rs=ps.executeQuery();
            while (rs.next())
            {
                testid=rs.getInt("testid");
                answer=rs.getString("answer");
                examtestid=rs.getInt(3);
            }
            stuexam1=new stuexam(testid,answer,uid,examid,examtestid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return stuexam1;
    }
    public void updatestuexam(stuexam stuexam)
    {
        util=new Util();
        Connection con= util.getConnection();
        int testid=stuexam.getTestid();
        String answer=stuexam.getAnswer();
        int uid=stuexam.getUid1();
        int examid=stuexam.getExamid();
        int examtestid=stuexam.getExamtestid();
        String sql="insert into stuexam (testid,answer,uid,examid,examtestid) values (?,?,?,?,?)";
        String sql1="update stuexam set answer=? where testid=? and uid=? and examid=? and examtestid=?";
        try {
            ps=con.prepareStatement(sql1);
            ps.setString(1,answer);
            ps.setInt(2,testid);
            ps.setInt(3,uid);
            ps.setInt(4,examid);
            ps.setInt(5,examtestid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(con,ps);
        }
    }
    public stuexam getstuexam(stuexam stuexam)
    {
        stuexam stuexam1=null;
        util=new Util();
        Connection connection= util.getConnection();
        int uid=stuexam.getUid1();
        int examid=stuexam.getExamid();
        int examtestid=stuexam.getExamtestid();
        int testid=0;
        String answer=null;
        String sql="select testid, answer from stuexam where uid=? and examid=? and examtestid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,uid);
            ps.setInt(2,examid);
            ps.setInt(3,examtestid);
            rs=ps.executeQuery();
            while (rs.next())
            {
                testid=rs.getInt("testid");
                answer=rs.getString("answer");
            }
            stuexam1=new stuexam(testid,answer,uid,examid,examtestid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return stuexam1;
    }

    public void addstuscore(stu_score stu_score)
    {
        util=new Util();
        Connection connection= util.getConnection();
        int uid=stu_score.getUid1();
        int examid=stu_score.getExamid();
        int selectscore=stu_score.getSelectscore();
        String sql="insert into stu_score (selectscore,examid,uid) values (?,?,?)";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,selectscore);
            ps.setInt(2,examid);
            ps.setInt(3,uid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
    }
    public int[] getstuscoreexmid(stu_score stu_score)
    {
        String[] str=new String[0];
        ArrayList arrayList=new ArrayList();
        int[] num = new int[0];
        stu_score stuScore = null;
        util=new Util();
        Connection connection= util.getConnection();
        int uid=stu_score.getUid1();
        int examid=stu_score.getExamid();
        int selecscore;
        int iiscore;
        int stuscore;
        String sql="select examid from stu_score where uid=?";
        try {
            ps=connection.prepareStatement(sql);
            //ps.setInt(1,examid);
            ps.setInt(1,uid);
            rs=ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();
            //num=new int[columnCount];
            while (rs.next())
            {
                for (int i = 1; i <= columnCount; i++){
                    arrayList.add(rs.getInt(i));
                }
            }
            str=new String[arrayList.size()];
            num=new int[arrayList.size()];
            for (int j=0;j<arrayList.size();j++)
            {
                System.out.println(arrayList.get(j));
                str[j]=arrayList.get(j).toString();
                num[j]=Integer.parseInt(str[j]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return num;
    }
    public stu_score selectstuscore(stu_score stu_score)
    {
        stu_score stuScore = null;
        util=new Util();
        Connection connection= util.getConnection();
        int uid=stu_score.getUid1();
        int examid=stu_score.getExamid();
        int selecscore;
        int iiscore;
        int stuscore;
        String sql="select selectscore,examid,uid,iiscore,stuscore from stu_score where examid=? and uid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,examid);
            ps.setInt(2,uid);
            rs=ps.executeQuery();
            while (rs.next())
            {
                selecscore=rs.getInt(1);
                examid=rs.getInt(2);
                uid=rs.getInt(3);
                iiscore=rs.getInt(4);
                stuscore=rs.getInt(5);
                stuScore=new stu_score(selecscore,examid,uid,iiscore,stuscore);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return stuScore;
    }
    public void updatestuscore(stu_score stuScore)
    {
        util=new Util();
        Connection connection= util.getConnection();
        int uid=stuScore.getUid1();
        int examid=stuScore.getExamid();
        int iiscore=stuScore.getIiscore();
        int stuscore=stuScore.getStuscore();
        String sql="update stu_score set iiscore=?,stuscore=? where uid=? and examid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,iiscore);
            ps.setInt(2,stuscore);
            ps.setInt(3,uid);
            ps.setInt(4,examid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
    }
    public void release(Connection conn, Statement st, ResultSet rs) {
        //关闭资源
        try {
            if(null != rs)
                rs.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if(null != st)
                st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if(null != conn)
                conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void  setstuexampaper(int examid,int uid)
    {
        util=new Util();
        Connection connection= util.getConnection();
        String sql="insert into stuexampaper (examid,uid) values (?,?)";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,examid);
            ps.setInt(2,uid);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
    }
    public String[] getstuexampaper(int uid)
    {
        ArrayList arrayList=new ArrayList();
        String[] strings = new String[0];
        util=new Util();
        Connection connection= util.getConnection();
        String sql="select distinct examid from stuexampaper where uid=?";
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,uid);
            rs=ps.executeQuery();

            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();
            //strings=new String[columnCount];
            while (rs.next())
            {
                for (int i = 1; i <= columnCount; i++){
                    arrayList.add(rs.getInt(i));
                }
            }
            strings=new String[arrayList.size()];
            for (int j=0;j<arrayList.size();j++)
            {
                System.out.println(arrayList.get(j));
                strings[j]=arrayList.get(j).toString();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            release(connection,ps);
        }
        return strings;
    }
    /**
     * 释放资源重载
     * @param conn
     * @param st
     */
    public void release(Connection conn,Statement st) {
        //关闭资源
        try {
            if(null != st)
                st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if(null != conn)
                conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
