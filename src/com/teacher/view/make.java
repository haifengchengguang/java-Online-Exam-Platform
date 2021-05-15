package com.teacher.view;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import com.server.dao;
import com.test.Exam;
import com.test.Test;
import com.test.myModel;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Mon May 10 20:35:38 CST 2021
 */



/**
 * @author Brainrain
 */
public class make extends JFrame {
    myModel model;

    int globaltestid;
    ArrayList arrayList=new ArrayList();
    public make(myModel model) {
        this.model=model;
        initComponents();
        list1.setModel(model);
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=list1.getSelectedIndex()+1;
                globaltestid=i;
                Test test=new Test(i);
                dao dao=new dao();
                Test test1=dao.gettestfromdb(test);
                textArea2.setText(test1.getQuestion());

            }
        });
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        int examtestid= Integer.parseInt(textField12.getText());
        System.out.println("examtestid="+examtestid);
        int examid=Integer.parseInt(textField11.getText());
        int testid=globaltestid;
        System.out.println("testid"+testid);
        dao dao=new dao();
        Exam exam=new Exam(examid);
        exam.setExamtestid(examtestid);
        exam.setTestid(testid);
        dao.daosetexam(exam);
        arrayList.add(testid);
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here

        dao dao=new dao();
        ArrayList arrayList1=dao.gettestidfromdb(Integer.parseInt(textField11.getText()));
        System.out.println(textField11.getText());
        ArrayList arrayList2=new ArrayList();
        String str="";
        for(int i=0;i<arrayList1.size();i++)
        {
            Test test=new Test((Integer) arrayList1.get(i));
            Test test1=dao.gettestfromdb(test);
            arrayList2.add(i+1+"."+test1.getQuestion());
            System.out.println(test1.getQuestion());
            str+= (String) arrayList2.get(i)+"\n";
        }
        textArea1.setText(str);
        frame1.setVisible(true);

    }

    private void button5MouseClicked(MouseEvent e) {
        // TODO add your code here
        int fillblank= Integer.parseInt(textField1.getText());
        int select=Integer.parseInt(textField2.getText());
        int shortqs=Integer.parseInt(textField3.getText());
        frame2.setVisible(false);
        frame3.setVisible(false);
        frame1.setVisible(false);
        textField11.setText("1001");
        this.setVisible(true);
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        this.setVisible(true);
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        frame3.setVisible(true);
    }

    private void button6MouseClicked(MouseEvent e) {
        // TODO add your code here
        int examtestid= Integer.parseInt(textField12.getText());
        int examid=Integer.parseInt(textField11.getText());
        int testid=globaltestid;
        dao dao=new dao();
        Exam exam=new Exam(examid);
        exam.setExamtestid(examtestid);
        dao.daodelExam(exam);
        dao.daodelsub1Exam(exam);
        //arrayList.remove(examtestid);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField11 = new JTextField();
        label6 = new JLabel();
        textField12 = new JTextField();
        textField13 = new JTextField();
        button2 = new JButton();
        button6 = new JButton();
        button1 = new JButton();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        scrollPane3 = new JScrollPane();
        list1 = new JList<>();
        frame1 = new JFrame();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        frame2 = new JFrame();
        button3 = new JButton();
        button4 = new JButton();
        frame3 = new JFrame();
        label4 = new JLabel();
        label5 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField4 = new JTextField();
        label1 = new JLabel();
        textField2 = new JTextField();
        textField5 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        textField6 = new JTextField();
        button5 = new JButton();

        //======== this ========
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
            "[]"));

        //---- textField11 ----
        textField11.setText("\u8bd5\u9898\u7f16\u53f7");
        contentPane.add(textField11, "cell 1 1 2 1");

        //---- label6 ----
        label6.setText("\u7b2c\u51e0\u9898");
        contentPane.add(label6, "cell 4 1 2 1");

        //---- textField12 ----
        textField12.setText("1");
        contentPane.add(textField12, "cell 6 1");

        //---- textField13 ----
        textField13.setEditable(false);
        contentPane.add(textField13, "cell 8 1");

        //---- button2 ----
        button2.setText("\u6dfb\u52a0");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });
        contentPane.add(button2, "cell 11 1");

        //---- button6 ----
        button6.setText("\u5220\u9664");
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button6MouseClicked(e);
            }
        });
        contentPane.add(button6, "cell 12 1");

        //---- button1 ----
        button1.setText("\u9884\u89c8");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 13 1");

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setRows(60);
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2, "cell 1 2 13 13");

        //======== scrollPane3 ========
        {

            //---- list1 ----
            list1.setVisibleRowCount(60);
            list1.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "1",
                    "2",
                    "3",
                    "4",
                    "5"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            scrollPane3.setViewportView(list1);
        }
        contentPane.add(scrollPane3, "cell 17 2 3 13");
        setSize(660, 530);
        setLocationRelativeTo(getOwner());

        //======== frame1 ========
        {
            var frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new MigLayout(
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
                "[]"));

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setRows(60);
                textArea1.setLineWrap(true);
                textArea1.setEditable(false);
                scrollPane1.setViewportView(textArea1);
            }
            frame1ContentPane.add(scrollPane1, "cell 2 1 22 3");
            frame1.setSize(525, 465);
            frame1.setLocationRelativeTo(frame1.getOwner());
        }

        //======== frame2 ========
        {
            var frame2ContentPane = frame2.getContentPane();
            frame2ContentPane.setLayout(new MigLayout(
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
                "[]"));

            //---- button3 ----
            button3.setText("\u624b\u52a8\u7ec4\u5377");
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });
            frame2ContentPane.add(button3, "cell 6 5 9 3");

            //---- button4 ----
            button4.setText("\u81ea\u52a8\u7ec4\u5377");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                }
            });
            frame2ContentPane.add(button4, "cell 6 10 9 1");
            frame2.setSize(245, 200);
            frame2.setLocationRelativeTo(frame2.getOwner());
        }

        //======== frame3 ========
        {
            var frame3ContentPane = frame3.getContentPane();
            frame3ContentPane.setLayout(new MigLayout(
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
                "[]"));

            //---- label4 ----
            label4.setText("\u9898\u76ee\u6570\u91cf");
            frame3ContentPane.add(label4, "cell 3 3 2 1");

            //---- label5 ----
            label5.setText("\u9898\u76ee\u96be\u5ea6");
            frame3ContentPane.add(label5, "cell 9 3 3 1");

            //---- label2 ----
            label2.setText("\u586b\u7a7a\u9898");
            frame3ContentPane.add(label2, "cell 1 5");
            frame3ContentPane.add(textField1, "cell 2 5 5 1");
            frame3ContentPane.add(textField4, "cell 7 5 6 1");

            //---- label1 ----
            label1.setText("\u9009\u62e9\u9898");
            frame3ContentPane.add(label1, "cell 1 6 1 3");
            frame3ContentPane.add(textField2, "cell 2 7 5 1");
            frame3ContentPane.add(textField5, "cell 7 7 6 1");

            //---- label3 ----
            label3.setText("\u4e3b\u89c2\u9898");
            frame3ContentPane.add(label3, "cell 1 9");
            frame3ContentPane.add(textField3, "cell 2 9 5 1");
            frame3ContentPane.add(textField6, "cell 7 9 6 1");

            //---- button5 ----
            button5.setText("\u751f\u6210");
            button5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button5MouseClicked(e);
                }
            });
            frame3ContentPane.add(button5, "cell 13 13");
            frame3.setSize(370, 310);
            frame3.setLocationRelativeTo(frame3.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField11;
    private JLabel label6;
    private JTextField textField12;
    private JTextField textField13;
    private JButton button2;
    private JButton button6;
    private JButton button1;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JScrollPane scrollPane3;
    private JList<String> list1;
    private JFrame frame1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    JFrame frame2;
    private JButton button3;
    private JButton button4;
    private JFrame frame3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField4;
    private JLabel label1;
    private JTextField textField2;
    private JTextField textField5;
    private JLabel label3;
    private JTextField textField3;
    private JTextField textField6;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
