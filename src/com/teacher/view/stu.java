package com.teacher.view;

import java.awt.event.*;
import javax.swing.*;

import com.server.dao;
import com.test.*;
import net.miginfocom.swing.*;

/*
 * Created by JFormDesigner on Mon May 10 00:28:28 CST 2021
 */



/**
 * @author Brainrain
 */
public class stu extends JFrame {
    private int examid;
    private int stuid;
    private myModel model;
    int iitestid;
    String[] strings;
    int iiscore;
    int stuscore;
    public stu(String[] strings,int examid) {
        //this.model=model;
        this.strings=strings;
        this.examid=examid;
        initComponents();
        //list1.setModel(model);
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
                //int i=list1.getSelectedIndex()+1;
                int i= Integer.parseInt(list1.getSelectedValue());
                stuid=i;
                //int examtestid= Integer.parseInt(textField2.getText());
                dao dao=new dao();
                stuexam stuexam=new stuexam(stuid,examid);
                stuexam stuexam1;
                stuexam1=dao.techgetstuexam(stuexam);
                iitestid=stuexam1.getExamtestid();
                textField2.setText(stuexam1.getExamtestid()+"");
                textArea2.setText(stuexam1.getAnswer());
                Test test=new Test(stuexam1.getTestid());
                Test test1=dao.gettestfromdb(test);
                textArea1.setText(test1.getQuestion());

            }
        });
    }
    private void button1MouseClicked(MouseEvent e) {
        this.setVisible(false);
    }
    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dao dao=new dao();
        Exam exam=new Exam(examid);
        int maxexamtestid=dao.daogetmaxexamtestid(exam);
        if(iitestid<=Integer.parseInt(textField2.getText())&&Integer.parseInt(textField2.getText())<=maxexamtestid) {
            int examtestid= Integer.parseInt(textField2.getText());
            stuexam stuexam=new stuexam(stuid,examid,examtestid);

            stuexam stuexam1=dao.getstuexam(stuexam);
            textArea2.setText(stuexam1.getAnswer());
            Test test=new Test(stuexam1.getTestid());
            Test test1=dao.gettestfromdb(test);
            textArea1.setText(test1.getQuestion());
            textField2.setText(examtestid+"");
        }
        else {
            JOptionPane.showMessageDialog(this,"\u9898\u76ee\u4e0d\u5b58\u5728");
        }
    }
    private void button6MouseClicked(MouseEvent e) {
        // TODO add your code here
        dao dao=new dao();
        Exam exam=new Exam(examid);
        int maxexamtestid=dao.daogetmaxexamtestid(exam);
        if(iitestid<=(Integer.parseInt(textField2.getText())-1)&&(Integer.parseInt(textField2.getText())-1)<=maxexamtestid) {

            int examtestid= Integer.parseInt(textField2.getText())-1;
            stuexam stuexam=new stuexam(stuid,examid,examtestid);

            stuexam stuexam1=dao.getstuexam(stuexam);
            textArea2.setText(stuexam1.getAnswer());
            Test test=new Test(stuexam1.getTestid());
            Test test1=dao.gettestfromdb(test);
            textArea1.setText(test1.getQuestion());
            textField2.setText(examtestid+"");
        }
        else {
            JOptionPane.showMessageDialog(this,"\u9898\u76ee\u4e0d\u5b58\u5728");
        }
    }

    private void button7MouseClicked(MouseEvent e) {
        // TODO add your code here
        dao dao=new dao();
        Exam exam=new Exam(examid);
        int maxexamtestid=dao.daogetmaxexamtestid(exam);
        if(iitestid<=(Integer.parseInt(textField2.getText())+1)&&(Integer.parseInt(textField2.getText())+1)<=maxexamtestid) {

            int examtestid= Integer.parseInt(textField2.getText())+1;
            stuexam stuexam=new stuexam(stuid,examid,examtestid);

            stuexam stuexam1=dao.getstuexam(stuexam);
            textArea2.setText(stuexam1.getAnswer());
            Test test=new Test(stuexam1.getTestid());
            Test test1=dao.gettestfromdb(test);
            textArea1.setText(test1.getQuestion());
            textField2.setText(examtestid+"");
        }
        else {
            JOptionPane.showMessageDialog(this,"\u9898\u76ee\u4e0d\u5b58\u5728");
        }
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        dao dao=new dao();
        Exam exam=new Exam(examid);

            iiscore += Integer.parseInt(textField1.getText());
            stu_score stuScore=new stu_score(examid,stuid);
            stu_score stuScore1=dao.selectstuscore(stuScore);
            stuscore=iiscore+stuScore1.getSelectscore();
            stu_score stuScore3 = new stu_score(examid, stuid, iiscore,stuscore);
            dao.updatestuscore(stuScore3);

        }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        scrollPane2 = new JScrollPane();
        list1 = new JList<>();
        scrollPane3 = new JScrollPane();
        textArea2 = new JTextArea();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button1 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "fill,hidemode 3,aligny top",
            // columns
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]" +
            "[fill]0" +
            "[fill]" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[fill]" +
            "[fill]0" +
            "[fill]0" +
            "[fill]0" +
            "[229,fill]" +
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
            "[137]" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]"));

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setColumns(30);
            textArea1.setRows(20);
            textArea1.setEditable(false);
            textArea1.setText("\u5728\u8fd9\u5448\u73b0\u9898\u76ee");
            textArea1.setWrapStyleWord(true);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1, "cell 2 3 44 2,grow");

        //======== scrollPane2 ========
        {

            //---- list1 ----
            list1.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "s1",
                    "s2",
                    "s3",
                    "\u8c03\u7528model\u7684\u65b9\u6cd5\u9009\u62e9\u5b66\u751f"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            scrollPane2.setViewportView(list1);
        }
        contentPane.add(scrollPane2, "cell 52 3 21 3,grow");

        //======== scrollPane3 ========
        {

            //---- textArea2 ----
            textArea2.setColumns(30);
            textArea2.setRows(20);
            textArea2.setEditable(false);
            textArea2.setText("\u5728\u8fd9\u5448\u73b0\u7b54\u9898\u7684\u60c5\u51b5");
            textArea2.setWrapStyleWord(true);
            scrollPane3.setViewportView(textArea2);
        }
        contentPane.add(scrollPane3, "cell 2 5 44 1,grow");

        //---- label1 ----
        label1.setText("\u8be5\u9898\u5f97\u5206");
        contentPane.add(label1, "cell 26 8");

        //---- textField1 ----
        textField1.setText("\u9605\u5377\u7684\u65f6\u5019\u53ef\u7f16\u8f91\uff0c\u67e5\u770b\u6210\u7ee9\u7684\u65f6\u5019\u4e0d\u53ef\u7f16\u8f91");
        contentPane.add(textField1, "cell 28 8 18 1");

        //---- label2 ----
        label2.setText("\u9898\u76ee\u7f16\u53f7");
        contentPane.add(label2, "cell 26 16");

        //---- textField2 ----
        textField2.setText("1");
        contentPane.add(textField2, "cell 27 16 3 1");

        //---- button2 ----
        button2.setText("\u8f6c\u5230");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2, "cell 31 16");

        //---- button3 ----
        button3.setText("\u4fdd\u5b58");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked(e);
            }
        });
        contentPane.add(button3, "cell 33 16");

        //---- button6 ----
        button6.setText("\u4e0a\u4e00\u9898");
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button6MouseClicked(e);
            }
        });
        contentPane.add(button6, "cell 35 16,grow");

        //---- button7 ----
        button7.setText("\u4e0b\u4e00\u9898");
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button7MouseClicked(e);
            }
        });
        contentPane.add(button7, "cell 36 16,grow");

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 68 16");
        setSize(940, 665);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JScrollPane scrollPane2;
    private JList<String> list1;
    private JScrollPane scrollPane3;
    private JTextArea textArea2;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button2;
    private JButton button3;
    private JButton button6;
    private JButton button7;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
