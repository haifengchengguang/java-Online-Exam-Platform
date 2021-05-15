package com.student.view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;

import com.common.Message;
import com.common.MsgType;
import com.server.ManageThread;
import com.server.dao;
import com.student.tool.ClientToServerThread;
import com.test.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Tue May 11 10:42:13 CST 2021
 */



/**
 * @author Brainrain
 */
public class student extends JFrame{
    public static void main(String[] args) {
        student student=new student("1","1");
        student.setVisible(true);
    }
    Timer timer;
    private String uname;
    private String ownerId;
    public student(String uname, String ownerId) {
        this.uname = uname;
        this.ownerId = ownerId;
        //this.addWindowListener(this);
        initComponents();
        panel2.setVisible(false);
        label1.setText(uname);

    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        panel2.setVisible(true);
        dao dao=new dao();
        String[] strings;
        strings=dao.getstuexampaper(Integer.parseInt(ownerId));

        list1.setModel(new AbstractListModel<String>() {
            String[] values = strings;
            @Override
            public int getSize() { return values.length; }
            @Override
            public String getElementAt(int i) { return values[i]; }
        });
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int examid= Integer.parseInt(list1.getSelectedValue());
                System.out.println("examid="+examid);
                int examtestid= Integer.parseInt(textField2.getText());
                Exam exam=new Exam(examid);
                Exam exam1= dao.daogetExam1(exam);
                textField4.setText("\u79d1\u76ee:"+exam1.getExamname()+"\u8003\u8bd5\u65f6\u95f4:"+exam1.getTime()+"\u603b\u5206:"+100);
                textField3.setText(exam1.getExamid()+"");
            }
        });
        this2.setVisible(true);
        /*changci changci=new changci(model,this);
        changci.setVisible(true);*/



    }
    int pd;
    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        if(pd==0)
        {
            pd=1;
            timer =new Timer("exam");
            this.add(timer.getContentPane(),"cell 0 0");
            timer.startPauseButton.doClick();
        }
        int examid= Integer.parseInt(textField3.getText());

        int examtestid= Integer.parseInt(textField2.getText());
        System.out.println("examid="+examid);
        System.out.println("examtestid="+examtestid);
        Exam exam=new Exam(examid,examtestid);
        dao dao=new dao();
        Exam exam1=dao.daogetExam(exam);
        Test test=new Test(exam1.getTestid());
        Test test1=dao.gettestfromdb(test);
        textArea1.setText(test1.getQuestion());
        int questiontype=test1.getQustiontype();
        if(questiontype==1)
        {
            radioButton4.setVisible(true);
            radioButton3.setVisible(true);
            radioButton2.setVisible(true);
            radioButton1.setVisible(true);
            textField5.setText("\u9009\u62e9\u9898");
            textArea3.setVisible(false);
            textField1.setVisible(false);
        }
        else if(questiontype==2)
        {
            radioButton3.setVisible(false);
            radioButton1.setVisible(false);
            radioButton2.setVisible(false);
            radioButton4.setVisible(false);
            textField1.setVisible(true);
            textArea3.setVisible(false);
            textField5.setText("\u586b\u7a7a\u9898");
        }
        else if (questiontype==3)
        {
            radioButton4.setVisible(false);
            radioButton3.setVisible(false);
            radioButton2.setVisible(false);
            radioButton1.setVisible(false);
            textField1.setVisible(false);
            textArea3.setVisible(true);
            textField5.setText("\u7b80\u7b54\u9898");
        }
        textField6.setText("\u9898\u76ee\u7edf\u8ba1"+examtestid+"/"+exam1.getCounttest());
        textField7.setText(test1.getTestid()+"");
        textField8.setText(questiontype+"");
        textField9.setText(exam1.getCounttest()+"");
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        String answer=null;
        if (textField8.getText().equals("1"))
        {
            if(radioButton1.isSelected()){
                answer="A";
            }
            else if(radioButton2.isSelected())
            {
                answer="B";
            }
            else if (radioButton3.isSelected())
            {
                answer="C";
            }
            else if (radioButton4.isSelected())
            {
                answer="D";
            }
        }
        else if(textField8.getText().equals("2"))
        {
            answer=textField1.getText();
        }
        else if (textField8.getText().equals("3"))
        {
            answer=textArea3.getText();
        }
        int uid= Integer.parseInt(ownerId);
        //tring answer=textArea3.getText();
        int examid= Integer.parseInt(textField3.getText());
        int testid=Integer.parseInt(textField7.getText());
        int examtestid=Integer.parseInt(textField2.getText());
        stuexam stuexam=new stuexam(testid,answer,uid,examid,examtestid);
        stuexam stuexam1=new stuexam(uid,examid,examtestid);
        dao dao=new dao();
        stuexam stuexam2=dao.getstuexam(stuexam1);
        if(stuexam2.getAnswer()==null)
        dao.setstuexam(stuexam);
        else if(!stuexam2.getAnswer().equals(stuexam.getAnswer()))
        {
            dao.updatestuexam(stuexam);
        }

    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        int examid= Integer.parseInt(textField3.getText());
        int examtestid= Integer.parseInt(textField2.getText());
        Exam exam=new Exam(examid,examtestid);
        dao dao=new dao();
        if(examtestid<=dao.daogetmaxexamtestid(exam)&&examtestid>0){
        Exam exam1=dao.daogetExam(exam);
        Test test=new Test(exam1.getTestid());
        Test test1=dao.gettestfromdb(test);
        int uid=Integer.parseInt(ownerId);
        stuexam stuexam=new stuexam(uid,examid,examtestid);
        stuexam stuexam1=dao.getstuexam(stuexam);
        textArea3.setText(stuexam1.getAnswer());
        textArea1.setText(test1.getQuestion());
        int questiontype=test1.getQustiontype();
        if(questiontype==1)
        {
            textField5.setText("\u9009\u62e9\u9898");
        }
        else if(questiontype==2)
        {
            textField5.setText("\u586b\u7a7a\u9898");
        }
        else if (questiontype==3)
        {
            textField5.setText("\u7b80\u7b54\u9898");
        }
        textField6.setText("\u9898\u76ee\u7edf\u8ba1"+examtestid+"/"+exam1.getCounttest());
        textField7.setText(test1.getTestid()+"");
        textField8.setText(questiontype+"");
    }
        else JOptionPane.showMessageDialog(this,"\u9898\u76ee\u4e0d\u5b58\u5728");
    }


    private void button5MouseClicked(MouseEvent e) {
        // TODO add your code here
        dao dao=new dao();
        //int examid= Integer.parseInt(textField3.getText());
        stu_score stuScore=new stu_score(Integer.parseInt(ownerId));
        int[] num=dao.getstuscoreexmid(stuScore);
        int lenth=num.length;
        String[][] strings=new String[lenth][5];
        for(int i=0;i<lenth;i++)
        {

            int tempexamid=num[i];
            stu_score stuScore1=new stu_score(tempexamid,Integer.parseInt(ownerId));
            stu_score stuScore2=dao.selectstuscore(stuScore1);
            int totalscore=stuScore2.getStuscore();
            int iiscore=stuScore2.getIiscore();
            int selectscore=stuScore2.getSelectscore();
            String examname=dao.daogetexamname(num[i]);
            strings[i][0]=num[i]+"";
            strings[i][1]=examname;
            strings[i][2]=totalscore+"";
            strings[i][3]=selectscore+"";
            strings[i][4]=iiscore+"";
        }
        score score=new score(strings);
        score.setVisible(true);

    }

    private void button8MouseClicked(MouseEvent e) {
        // TODO add your code here
        int option = JOptionPane.showConfirmDialog(this, "\u662f\u5426\u4ea4\u5377"+"?", "\u63d0\u793a",
                JOptionPane.YES_NO_OPTION);//是否交卷
        if (option == JOptionPane.YES_OPTION)
        {
            timer.setVisible(false);
            pd=0;
            int selectscore = 0;
            int counttest= Integer.parseInt(textField9.getText());
            int examid=Integer.parseInt(textField3.getText());
            dao dao=new dao();
            Exam exam=new Exam(examid);
            for (int i=1;i<=dao.daogetmaxexamtestid(exam);i++)
            {
                int examtestid=i;
                int uid= Integer.parseInt(ownerId);
                Exam exam2=new Exam(examid,examtestid);
                Exam exam1;

                exam1=dao.daogetExam(exam2);
                Test test=new Test(exam1.getTestid());
                Test test1;
                test1=dao.gettestfromdb(test);
                stuexam stuexam=new stuexam(uid,examid,examtestid);
                stuexam stuexam1;
                stuexam1=dao.getstuexam(stuexam);
                if(test1.getAnswer().equals(stuexam1.getAnswer()))
                {
                    selectscore+=test1.getScore();
                }
            }
            stu_score stu_score=new stu_score(selectscore,examid,Integer.parseInt(ownerId));
            dao.addstuscore(stu_score);

            textArea1.setText(null);
            textArea3.setText("\u4e3b\u89c2\u9898\u7b54\u9898\u533a");
            textField1.setText(null);
            textField2.setText(null);
            textField3.setText(null);
            textField4.setText(null);
            textField5.setText(null);
            textField6.setText(null);
            textField7.setText(null);
            textField8.setText(null);
            textField9.setText(null);
            JOptionPane.showMessageDialog(this,"\u9009\u62e9\u9898\u5f97\u5206"+selectscore,"\u4ea4\u5377\u6210\u529f",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void button9MouseClicked(MouseEvent e) {
        // TODO add your code here
        this2.setVisible(false);
    }

    private void button10MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button11MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void textArea1KeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void button6MouseClicked(MouseEvent e) {

        // TODO add your code here
        dao dao = new dao();
        int examid = Integer.parseInt(textField3.getText());
        int examtestid1 = Integer.parseInt(textField2.getText()) - 1;
        Exam exam = new Exam(examid, examtestid1);
        int maxlenth=dao.daogetmaxexamtestid(exam);
        if (examtestid1 <= dao.daogetmaxexamtestid(exam) && examtestid1 > 0) {
            textField2.setText(examtestid1 + "");


            Exam exam1 = dao.daogetExam(exam);
            Test test = new Test(exam1.getTestid());
            Test test1 = dao.gettestfromdb(test);
            int uid = Integer.parseInt(ownerId);
            stuexam stuexam2 = new stuexam(uid, examid, examtestid1);
            stuexam stuexam1 = dao.getstuexam(stuexam2);
            textArea3.setText(stuexam1.getAnswer());
            textArea1.setText(test1.getQuestion());
            int questiontype = test1.getQustiontype();
            if (questiontype == 1) {
                radioButton4.setVisible(true);
                radioButton3.setVisible(true);
                radioButton2.setVisible(true);
                radioButton1.setVisible(true);
                textField5.setText("\u9009\u62e9\u9898");
                textArea3.setVisible(false);
                textField1.setVisible(false);
            } else if (questiontype == 2) {
                radioButton3.setVisible(false);
                radioButton1.setVisible(false);
                radioButton2.setVisible(false);
                radioButton4.setVisible(false);
                textField1.setVisible(true);
                textArea3.setVisible(false);
                textField5.setText("\u586b\u7a7a\u9898");
            } else if (questiontype == 3) {
                radioButton4.setVisible(false);
                radioButton3.setVisible(false);
                radioButton2.setVisible(false);
                radioButton1.setVisible(false);
                textField1.setVisible(false);
                textArea3.setVisible(true);
                textField5.setText("\u7b80\u7b54\u9898");
            }
            //dao.daogetmaxexamtestid()
            textField6.setText("\u9898\u76ee\u7edf\u8ba1" + examtestid1 + "/" + maxlenth);
            textField7.setText(test1.getTestid() + "");
            textField8.setText(questiontype + "");
        }
        else JOptionPane.showMessageDialog(this,"\u9898\u76ee\u4e0d\u5b58\u5728");
    }


    private void button7MouseClicked(MouseEvent e) {
        // TODO add your code here
        dao dao = new dao();

        int examid = Integer.parseInt(textField3.getText());
        int examtestid1 = Integer.parseInt(textField2.getText()) + 1;
        Exam exam = new Exam(examid, examtestid1);
        if (examtestid1 <= dao.daogetmaxexamtestid(exam) && examtestid1 > 0) {
            textField2.setText(examtestid1 + "");

            //dao dao=new dao();
            Exam exam1 = dao.daogetExam(exam);
            Test test = new Test(exam1.getTestid());
            Test test1 = dao.gettestfromdb(test);
            int uid = Integer.parseInt(ownerId);
            stuexam stuexam2 = new stuexam(uid, examid, examtestid1);
            stuexam stuexam1 = dao.getstuexam(stuexam2);
            textArea3.setText(stuexam1.getAnswer());
            textArea1.setText(test1.getQuestion());
            int questiontype = test1.getQustiontype();
            if (questiontype == 1) {
                radioButton4.setVisible(true);
                radioButton3.setVisible(true);
                radioButton2.setVisible(true);
                radioButton1.setVisible(true);
                textField5.setText("\u9009\u62e9\u9898");
                textArea3.setVisible(false);
                textField1.setVisible(false);
            } else if (questiontype == 2) {
                radioButton3.setVisible(false);
                radioButton1.setVisible(false);
                radioButton2.setVisible(false);
                radioButton4.setVisible(false);
                textField1.setVisible(true);
                textArea3.setVisible(false);
                textField5.setText("\u586b\u7a7a\u9898");
            } else if (questiontype == 3) {
                radioButton4.setVisible(false);
                radioButton3.setVisible(false);
                radioButton2.setVisible(false);
                radioButton1.setVisible(false);
                textField1.setVisible(false);
                textArea3.setVisible(true);
                textField5.setText("\u7b80\u7b54\u9898");
            }
            textField6.setText("\u9898\u76ee\u7edf\u8ba1" + examtestid1 + "/" + exam1.getCounttest());
            textField7.setText(test1.getTestid() + "");
            textField8.setText(questiontype + "");
        }
        else JOptionPane.showMessageDialog(this,"\u9898\u76ee\u4e0d\u5b58\u5728");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        button8 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        label1 = new JLabel();
        panel2 = new JPanel();
        label4 = new JLabel();
        textField4 = new JTextField();
        textField3 = new JTextField();
        textField8 = new JTextField();
        textField7 = new JTextField();
        textField9 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        textField6 = new JTextField();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        label3 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        button3 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        label2 = new JLabel();
        textField1 = new JTextField();
        scrollPane2 = new JScrollPane();
        textArea3 = new JTextArea();
        this2 = new JFrame();
        label6 = new JLabel();
        scrollPane3 = new JScrollPane();
        list1 = new JList<>();
        button9 = new JButton();

        //======== this ========
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "fill,hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[802,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== panel1 ========
        {
            panel1.setBackground(new Color(153, 204, 255));
            panel1.setLayout(new MigLayout(
                "fillx,hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]0" +
                "[]0" +
                "[]0" +
                "[]"));

            //---- button8 ----
            button8.setText("\u4ea4\u5377");
            button8.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                    button8MouseClicked(e);
                }
            });
            panel1.add(button8, "cell 4 0");

            //---- button2 ----
            button2.setText("\u83b7\u53d6\u8003\u8bd5\u4fe1\u606f");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            panel1.add(button2, "cell 7 0");

            //---- button4 ----
            button4.setText("\u5f00\u59cb\u8003\u8bd5");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                }
            });
            panel1.add(button4, "cell 11 0");

            //---- button5 ----
            button5.setText("\u6210\u7ee9");
            button5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button5MouseClicked(e);
                }
            });
            panel1.add(button5, "cell 15 0");

            //---- label1 ----
            label1.setText("\u6b64\u5904\u663e\u793a\u59d3\u540d");
            label1.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label1, "cell 19 0 3 1");
        }
        contentPane.add(panel1, "cell 6 0 1 2,grow");

        //======== panel2 ========
        {
            panel2.setLayout(new MigLayout(
                "fillx,hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]0" +
                "[fill]0" +
                "[fill]0" +
                "[fill]0" +
                "[fill]0" +
                "[fill]0" +
                "[fill]0" +
                "[fill]0" +
                "[fill]rel" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[82,fill]" +
                "[19,fill]" +
                "[fill]" +
                "[26,fill]" +
                "[71,fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label4 ----
            label4.setText("\u8003\u8bd5\u4fe1\u606f");
            panel2.add(label4, "cell 0 0");

            //---- textField4 ----
            textField4.setEditable(false);
            panel2.add(textField4, "cell 1 0 34 1,grow,wmin 23");

            //---- textField3 ----
            textField3.setEditable(false);
            textField3.setVisible(false);
            panel2.add(textField3, "cell 35 0 29 1,grow,wmin 17");

            //---- textField8 ----
            textField8.setEditable(false);
            textField8.setVisible(false);
            panel2.add(textField8, "cell 35 0 29 1");

            //---- textField7 ----
            textField7.setEditable(false);
            textField7.setVisible(false);
            panel2.add(textField7, "cell 35 0 29 1");

            //---- textField9 ----
            textField9.setEditable(false);
            textField9.setVisible(false);
            panel2.add(textField9, "cell 35 0 29 1");

            //---- label5 ----
            label5.setText("\u9898\u578b");
            panel2.add(label5, "cell 0 3,grow");

            //---- textField5 ----
            textField5.setEditable(false);
            panel2.add(textField5, "cell 1 3 34 1,grow,wmin 23");

            //---- textField6 ----
            textField6.setEditable(false);
            panel2.add(textField6, "cell 35 3 29 1,grow,wmin 17");

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 16));
                textArea1.setTabSize(0);
                textArea1.setLineWrap(true);
                textArea1.setRows(44);
                textArea1.setEditable(false);
                textArea1.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        textArea1KeyPressed(e);
                    }
                });
                scrollPane1.setViewportView(textArea1);
            }
            panel2.add(scrollPane1, "cell 0 4 64 21,grow");

            //---- radioButton1 ----
            radioButton1.setText("A");
            panel2.add(radioButton1, "cell 1 26,grow");

            //---- radioButton2 ----
            radioButton2.setText("B");
            panel2.add(radioButton2, "cell 3 26,grow");

            //---- radioButton3 ----
            radioButton3.setText("C");
            panel2.add(radioButton3, "cell 5 26,grow");

            //---- radioButton4 ----
            radioButton4.setText("D");
            panel2.add(radioButton4, "cell 7 26,grow");

            //---- label3 ----
            label3.setText("\u9898\u76ee\u7f16\u53f7");
            panel2.add(label3, "cell 15 26 2 1");

            //---- textField2 ----
            textField2.setText("1");
            panel2.add(textField2, "cell 18 26 16 1");

            //---- button1 ----
            button1.setText("\u8f6c\u5230");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel2.add(button1, "cell 34 26");

            //---- button3 ----
            button3.setText("\u4fdd\u5b58");
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });
            panel2.add(button3, "cell 35 26");

            //---- button6 ----
            button6.setText("\u4e0a\u4e00\u9898");
            button6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button6MouseClicked(e);
                }
            });
            panel2.add(button6, "cell 37 26,grow");

            //---- button7 ----
            button7.setText("\u4e0b\u4e00\u9898");
            button7.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button7MouseClicked(e);
                }
            });
            panel2.add(button7, "cell 38 26,grow");

            //---- label2 ----
            label2.setText("\u586b\u7a7a\u9898\u7b54\u9898\u533a");
            panel2.add(label2, "cell 40 26 4 1,grow");
            panel2.add(textField1, "cell 44 26 20 1,aligny bottom,grow 100 0");

            //======== scrollPane2 ========
            {

                //---- textArea3 ----
                textArea3.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 16));
                textArea3.setTabSize(0);
                textArea3.setLineWrap(true);
                textArea3.setRows(44);
                textArea3.setText("\u4e3b\u89c2\u9898\u7b54\u9898");
                textArea3.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        textArea1KeyPressed(e);
                    }
                });
                scrollPane2.setViewportView(textArea3);
            }
            panel2.add(scrollPane2, "cell 0 27 64 15");
        }
        contentPane.add(panel2, "cell 0 6 7 13");
        setSize(1020, 535);
        setLocationRelativeTo(getOwner());

        //======== this2 ========
        {
            var this2ContentPane = this2.getContentPane();
            this2ContentPane.setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label6 ----
            label6.setText("\u9009\u62e9\u8003\u8bd5\u573a\u6b21");
            label6.setHorizontalAlignment(SwingConstants.CENTER);
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 13f));
            this2ContentPane.add(label6, "cell 7 0 8 1,grow");

            //======== scrollPane3 ========
            {

                //---- list1 ----
                list1.setVisibleRowCount(34);
                list1.setModel(new AbstractListModel<String>() {
                    String[] values = {
                        "1",
                        "2",
                        "3"
                    };
                    @Override
                    public int getSize() { return values.length; }
                    @Override
                    public String getElementAt(int i) { return values[i]; }
                });
                scrollPane3.setViewportView(list1);
            }
            this2ContentPane.add(scrollPane3, "cell 3 1 13 2");

            //---- button9 ----
            button9.setText("\u786e\u5b9a");
            button9.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button9MouseClicked(e);
                }
            });
            this2ContentPane.add(button9, "cell 19 2");
            this2.setSize(515, 375);
            this2.setLocationRelativeTo(this2.getOwner());
        }

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);
        buttonGroup1.add(radioButton4);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JButton button8;
    private JButton button2;
    private JButton button4;
    private JButton button5;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label4;
    private JTextField textField4;
    private JTextField textField3;
    private JTextField textField8;
    private JTextField textField7;
    private JTextField textField9;
    private JLabel label5;
    private JTextField textField5;
    private JTextField textField6;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JLabel label3;
    private JTextField textField2;
    private JButton button1;
    private JButton button3;
    private JButton button6;
    private JButton button7;
    private JLabel label2;
    private JTextField textField1;
    private JScrollPane scrollPane2;
    private JTextArea textArea3;
    private JFrame this2;
    private JLabel label6;
    private JScrollPane scrollPane3;
    private JList<String> list1;
    private JButton button9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
