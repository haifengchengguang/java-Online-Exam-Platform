package com.teacher.view;

import javax.swing.table.*;
import com.common.Message;
import com.common.MsgType;

import com.server.ManageThread;
import com.server.dao;
import com.test.Test;
import com.test.myModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Sun Apr 11 23:31:16 CST 2021
 */


/**
 * @author Brainrain
 */
public class teacher1 extends JFrame  {
    String uname;
    String ownerId;
    int difficulty;
    public static void main(String[] args) {
        teacher1 teacher=new teacher1("1","1");
        teacher.setVisible(true);
    }
    public teacher1(String uname, String ownerId) {
        this.uname = uname;
        this.ownerId = ownerId;
        //this.addWindowListener(this);
        initComponents();
        label1.setText(uname);
    }

    private void textArea1KeyPressed(KeyEvent e) {
        // TODO add your code here
        if(e.getKeyCode()==10)
            textArea1.append("\r");
    }

    private void button7MouseClicked(MouseEvent e) {
        // TODO add your code here
        Test test1 = null;
        int testid = Integer.parseInt(textField1.getText()) + 1;

        /*Message message=new Message();
        message.setType(MsgType.FIND_TEST);
        message.setGetterId(ownerId);
        message.setTest(test);
        Message msg=null;
        try {


            ObjectOutput output1 = new ObjectOutputStream(ManageThread.getThread(this.ownerId).getClient().getOutputStream());
            output1.writeObject(message);


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }*/
        dao dao = new dao();
        int maxtestid = dao.getmaxtestid();
        if (testid > maxtestid||testid<=0) {
            JOptionPane.showMessageDialog(this, "\u6ca1\u6709\u8be5\u9898\u76ee");
            textField1.setText("1");
        } else {
            Test test = new Test(testid);
            test1 = dao.gettestfromdb(test);

            textField1.setText(String.valueOf(test1.getTestid()));
            textArea1.setText(test1.getQuestion());
            textField2.setText(String.valueOf(test1.getScore()));
            comboBox1.setSelectedIndex(test1.getDifficulty());

                textArea3.setText("");
                //checkBox4.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            } /*else if (test1.getDifficulty() == 2) {
                checkBox5.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            } else {
                checkBox6.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }*/
            }



    private void button6MouseClicked(MouseEvent e) {
        // TODO add your code here
        Test test1 = null;
        int testid = Integer.parseInt(textField1.getText()) - 1;
        dao dao = new dao();
        int maxtestid = dao.getmaxtestid();
        if (testid > maxtestid||testid<=0) {
            JOptionPane.showMessageDialog(this, "\u6ca1\u6709\u8be5\u9898\u76ee");
            textField1.setText("1");
        } else {
            Test test = new Test(testid);
        /*Message message=new Message();
        message.setType(MsgType.FIND_TEST);
        message.setGetterId(ownerId);
        message.setTest(test);
        Message msg=null;
        try {


            ObjectOutput output1 = new ObjectOutputStream(ManageThread.getThread(this.ownerId).getClient().getOutputStream());
            output1.writeObject(message);


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }*/
            //dao dao=new dao();
            test1 = dao.gettestfromdb(test);

            textField1.setText(String.valueOf(test1.getTestid()));
            textArea1.setText(test1.getQuestion());
            textField2.setText(String.valueOf(test1.getScore()));
            comboBox1.setSelectedIndex(test1.getDifficulty());

                //checkBox4.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    textArea3.setText("");
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            } /*else if (test1.getDifficulty() == 2) {
                checkBox5.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            } else {
                checkBox6.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            }
        }*/
    }

    private void button9MouseClicked(MouseEvent e) {
        // TODO add your code here
        //增加
        System.out.println("增加"+"add");
        //int testid= Integer.parseInt(textField1.getText());
        dao dao=new dao();
        int testid=dao.getmaxtestid()+1;
        textField1.setText(testid+"");
        String question=textArea1.getText();
        String selectanswer;
        String answer;
        int score= Integer.parseInt(textField2.getText());
        int questionType,difficult;
        if(checkBox1.isSelected()){
            questionType=1;//选择
            if(radioButton1.isSelected()){
                selectanswer="A";
            }
            else if(radioButton2.isSelected())
            {
                selectanswer="B";
            }
            else if(radioButton3.isSelected())
            {
                selectanswer="C";
            }
            else {
                selectanswer="D";
            }
            /*if(checkBox4.isSelected())
            {
                difficult=1;
            }
            else if(checkBox5.isSelected())
            {
                difficult=2;
            }
            else {
                difficult=3;
            }*/
            difficult=comboBox1.getSelectedIndex();
            Test test=new Test(testid,score,difficult,question,selectanswer,questionType);
            Message message=new Message();
            message.setType(MsgType.ADD_TEST);
            message.setTest(test);
            try {
                ObjectOutput output=new ObjectOutputStream(ManageThread.getThread(this.ownerId).getClient().getOutputStream());
                output.writeObject(message);
                System.out.println("发送成功"+"send");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(checkBox2.isSelected()){
            questionType=2;
            answer=textArea3.getText();
            /*if(checkBox4.isSelected())
            {
                difficult=1;
            }
            else if(checkBox5.isSelected())
            {
                difficult=2;
            }
            else {
                difficult=3;
            }*/
            difficult=comboBox1.getSelectedIndex();
            Test test=new Test(testid,score,difficult,question,answer,questionType);
            Message message=new Message();
            message.setType(MsgType.ADD_TEST);
            message.setTest(test);
            try {
                ObjectOutput output=new ObjectOutputStream(ManageThread.getThread(this.ownerId).getClient().getOutputStream());
                output.writeObject(message);
                System.out.println("发送成功"+"send");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else {
            questionType=3;
            answer=textArea3.getText();

            difficult=comboBox1.getSelectedIndex();
            Test test=new Test(testid,score,difficult,question,answer,questionType);
            Message message=new Message();
            message.setType(MsgType.ADD_TEST);
            message.setTest(test);
            try {
                ObjectOutput output=new ObjectOutputStream(ManageThread.getThread(this.ownerId).getClient().getOutputStream());
                output.writeObject(message);
                System.out.println("发送成功"+"send");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


    }

    private void button12MouseClicked(MouseEvent e) {
        // TODO add your code here
        //转到
        Test test1=null;
        dao dao=new dao();
        int maxtestid= dao.getmaxtestid();

        int testid= Integer.parseInt(textField1.getText());
        if(testid>maxtestid||testid<=0){
            JOptionPane.showMessageDialog(this,"\u6ca1\u6709\u8be5\u9898\u76ee");
            textField1.setText("1");
        }
        else {
            Test test = new Test(testid);
        /*Message message=new Message();
        message.setType(MsgType.FIND_TEST);
        message.setGetterId(ownerId);
        message.setTest(test);
        Message msg=null;
        try {


            ObjectOutput output1 = new ObjectOutputStream(ManageThread.getThread(this.ownerId).getClient().getOutputStream());
            output1.writeObject(message);


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }*/
            //dao dao=new dao();
            test1 = dao.gettestfromdb(test);

            textField1.setText(String.valueOf(test1.getTestid()));
            textArea1.setText(test1.getQuestion());
            textField2.setText(String.valueOf(test1.getScore()));

                textArea3.setText("");
                comboBox1.setSelectedIndex(test1.getDifficulty());
                if (test1.getQustiontype() == 1) {
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            } /*else if (test1.getDifficulty() == 2) {
                checkBox5.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            } else {
                checkBox6.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            }
        }
*/
    }

    private void button10MouseClicked(MouseEvent e) {
        // TODO add your code here
        int testid= Integer.parseInt(textField1.getText());
        Test test=new Test(testid);
        Message message=new Message();
        message.setType(MsgType.DEL_TEST);
        message.setTest(test);
        try {
            ObjectOutput output=new ObjectOutputStream(ManageThread.getThread(this.ownerId).getClient().getOutputStream());
            output.writeObject(message);
            System.out.println("发送成功"+"send");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        dao dao=new dao();
        int maxtestid=dao.getmaxtestid()-1;
        Test test2=new Test(maxtestid);
        Test test1=dao.gettestfromdb(test2);
        System.out.println("\u8fdb\u884c\u5220\u9664\u540e\u7684\u67e5\u8be2");
        System.out.println(test1.getQuestion());
            textField1.setText(String.valueOf(test1.getTestid()));
            textArea1.setText(test1.getQuestion());
            textField2.setText(String.valueOf(test1.getScore()));
            comboBox1.setSelectedIndex(test1.getDifficulty());
                //checkBox4.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    textArea3.setText("");
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            } /*else if (test1.getDifficulty() == 2) {
                checkBox5.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            } else {
                checkBox6.setSelected(true);
                if (test1.getQustiontype() == 1) {
                    checkBox1.setSelected(true);
                    if (test1.getAnswer().equals("A")) {
                        radioButton1.setSelected(true);
                    } else if (test1.getAnswer().equals("B")) {
                        radioButton2.setSelected(true);
                    } else if (test1.getAnswer().equals("C")) {
                        radioButton3.setSelected(true);
                    } else {
                        radioButton4.setSelected(true);
                    }
                } else if (test1.getQustiontype() == 2) {
                    checkBox2.setSelected(true);
                    textArea3.setText(test1.getAnswer());
                } else {
                    textArea3.setText(test1.getAnswer());
                    checkBox3.setSelected(true);
                }
            }*/



    private void button13MouseClicked(MouseEvent e) {
        // TODO add your code here
        int testid= Integer.parseInt(textField1.getText());
        String question=textArea1.getText();
        String selectanswer;
        String answer;
        int score= Integer.parseInt(textField2.getText());
        int questionType,difficult;
        if(checkBox1.isSelected()){
            questionType=1;//选择
            if(radioButton1.isSelected()){
                selectanswer="A";
            }
            else if(radioButton2.isSelected())
            {
                selectanswer="B";
            }
            else if(radioButton3.isSelected())
            {
                selectanswer="C";
            }
            else {
                selectanswer="D";
            }
            /*if(checkBox4.isSelected())
            {
                difficult=1;
            }
            else if(checkBox5.isSelected())
            {
                difficult=2;
            }
            else {
                difficult=3;
            }*/
            difficult=comboBox1.getSelectedIndex();
            Test test=new Test(testid,score,difficult,question,selectanswer,questionType);
            Message message=new Message();
            message.setType(MsgType.UPDATE_TEST);
            message.setTest(test);
            try {
                ObjectOutput output=new ObjectOutputStream(ManageThread.getThread(this.ownerId).getClient().getOutputStream());
                output.writeObject(message);
                System.out.println("发送成功"+"send");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(checkBox2.isSelected()){
            questionType=2;
            answer=textArea3.getText();
            /*if(checkBox4.isSelected())
            {
                difficult=1;
            }
            else if(checkBox5.isSelected())
            {
                difficult=2;
            }
            else {
                difficult=3;
            }*/
            difficult=comboBox1.getSelectedIndex();
            Test test=new Test(testid,score,difficult,question,answer,questionType);
            Message message=new Message();
            message.setType(MsgType.UPDATE_TEST);
            message.setTest(test);
            try {
                ObjectOutput output=new ObjectOutputStream(ManageThread.getThread(this.ownerId).getClient().getOutputStream());
                output.writeObject(message);
                System.out.println("发送成功"+"send");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else {
            questionType=3;
            answer=textArea3.getText();
            /*if(checkBox4.isSelected())
            {
                difficult=1;
            }
            else if(checkBox5.isSelected())
            {
                difficult=2;
            }
            else {
                difficult=3;
            }*/
            difficult=comboBox1.getSelectedIndex();
            Test test=new Test(testid,score,difficult,question,answer,questionType);
            Message message=new Message();
            message.setType(MsgType.UPDATE_TEST);
            message.setTest(test);
            try {
                ObjectOutput output=new ObjectOutputStream(ManageThread.getThread(this.ownerId).getClient().getOutputStream());
                output.writeObject(message);
                System.out.println("发送成功"+"send");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private void button11MouseClicked(MouseEvent e) {
        // TODO add your code here
        this2.setVisible(true);
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        dao dao=new dao();
        ArrayList num;
        num=dao.gettestidfromdb();
        myModel model=new myModel(num);
        if (model==null){
            System.out.println("model is null");
        }
        make make=new make(model);
        make.frame2.setVisible(true);
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        String[] strings1;
        String[] strings2;
        dao dao=new dao();
        String[] examidarray=dao.daogetexamid1();
        System.out.println("examidarraylenth="+examidarray.length);
        String[] studentarray=dao.getstu();
        exam exam=new exam(examidarray,studentarray);
        exam.setVisible(true);

    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        dao dao=new dao();
        String[] str;
        String[] examidlist;
        examidlist=dao.daogetexamid();
        //myModel model=new myModel(examidlist);
        yuejuan yuejuan=new yuejuan(examidlist);
        yuejuan.setVisible(true);
        /*ArrayList num;
        num=dao.getstuexam();
        myModel model=new myModel(num);
        stu stu=new stu(model);
        stu.setVisible(true);*/
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        dao dao=new dao();
        String[] strings=dao.getstu();
        String[][] strings1=new String[strings.length][2];
        for(int i=0;i<strings.length;i++)
        {
            strings1[i][0]=strings[i];
            strings1[i][1]=dao.getuname(strings[i]);
        }
        table2.setModel(new DefaultTableModel(
                strings1,
                new String[] {
                        "\u59d3\u540d", "\u5b66\u53f7"
                }
        ));
        this3.setVisible(true);

    }

    private void button5MouseClicked(MouseEvent e) {
        // TODO add your code here
        this4.setVisible(true);
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                picture picture=new picture();
                picture.setVisible(true);
            }
        });
    }

    private void button8MouseClicked(MouseEvent e) {
        // TODO add your code here
        panel2.setVisible(true);

    }

    private void thisMouseClicked(MouseEvent e) {
        // TODO add your code here
        this2.setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        button2 = new JButton();
        button4 = new JButton();
        button3 = new JButton();
        button1 = new JButton();
        button5 = new JButton();
        button8 = new JButton();
        label1 = new JLabel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        button9 = new JButton();
        button10 = new JButton();
        button13 = new JButton();
        button11 = new JButton();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        label3 = new JLabel();
        comboBox1 = new JComboBox<>();
        label4 = new JLabel();
        label6 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        scrollPane2 = new JScrollPane();
        textArea3 = new JTextArea();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        label2 = new JLabel();
        textField1 = new JTextField();
        button12 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        this2 = new JFrame();
        scrollPane3 = new JScrollPane();
        table1 = new JTable();
        button14 = new JButton();
        this3 = new JFrame();
        scrollPane4 = new JScrollPane();
        table2 = new JTable();
        button15 = new JButton();
        this4 = new JFrame();
        label7 = new JLabel();
        scrollPane5 = new JScrollPane();
        list1 = new JList<>();
        button16 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
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
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- button2 ----
            button2.setText("\u7ec4\u5377");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            panel1.add(button2, "cell 2 0");

            //---- button4 ----
            button4.setText("\u8003\u8bd5");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                }
            });
            panel1.add(button4, "cell 5 0");

            //---- button3 ----
            button3.setText("\u9605\u5377");
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button3MouseClicked(e);
                }
            });
            panel1.add(button3, "cell 8 0");

            //---- button1 ----
            button1.setText("\u5b66\u751f");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel1.add(button1, "cell 11 0");

            //---- button5 ----
            button5.setText("\u6210\u7ee9");
            button5.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button5MouseClicked(e);
                }
            });
            panel1.add(button5, "cell 14 0");

            //---- button8 ----
            button8.setText("\u7ef4\u62a4\u9898\u5e93");
            button8.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button8MouseClicked(e);
                }
            });
            panel1.add(button8, "cell 17 0");

            //---- label1 ----
            label1.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label1, "cell 18 0 6 1");
        }
        contentPane.add(panel1, "cell 0 0 62 1,grow");

        //======== panel2 ========
        {
            panel2.setVisible(false);
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

            //======== panel3 ========
            {
                panel3.setLayout(new MigLayout(
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
                    "[]"));

                //---- button9 ----
                button9.setText("\u589e\u52a0");
                button9.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button9MouseClicked(e);
                    }
                });
                panel3.add(button9, "cell 4 1");

                //---- button10 ----
                button10.setText("\u5220\u9664");
                button10.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button10MouseClicked(e);
                    }
                });
                panel3.add(button10, "cell 9 1");

                //---- button13 ----
                button13.setText("\u4fee\u6539");
                button13.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button13MouseClicked(e);
                    }
                });
                panel3.add(button13, "cell 15 1");

                //---- button11 ----
                button11.setText("\u7edf\u8ba1");
                button11.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button11MouseClicked(e);
                    }
                });
                panel3.add(button11, "cell 25 1");

                //---- checkBox1 ----
                checkBox1.setText("\u9009\u62e9\u9898");
                panel3.add(checkBox1, "cell 28 1");

                //---- checkBox2 ----
                checkBox2.setText("\u586b\u7a7a\u9898");
                panel3.add(checkBox2, "cell 29 1");

                //---- checkBox3 ----
                checkBox3.setText("\u4e3b\u89c2\u9898");
                panel3.add(checkBox3, "cell 30 1");

                //---- label3 ----
                label3.setText("||  \u9898\u76ee\u96be\u5ea6");
                panel3.add(label3, "cell 31 1");

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6",
                    "7",
                    "8",
                    "9",
                    "10"
                }));
                panel3.add(comboBox1, "cell 32 1");

                //---- label4 ----
                label4.setText("\u9898\u76ee");
                panel3.add(label4, "cell 1 4");

                //---- label6 ----
                label6.setText("\u5206\u6570");
                panel3.add(label6, "cell 4 4");
                panel3.add(textField2, "cell 4 4");

                //---- label5 ----
                label5.setText("\u7b54\u6848");
                panel3.add(label5, "cell 32 4");
            }
            panel2.add(panel3, "cell 0 0 42 7,grow");

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 16));
                textArea1.setTabSize(0);
                textArea1.setLineWrap(true);
                textArea1.setRows(44);
                textArea1.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        textArea1KeyPressed(e);
                    }
                });
                scrollPane1.setViewportView(textArea1);
            }
            panel2.add(scrollPane1, "cell 0 7 32 15,grow");

            //======== scrollPane2 ========
            {

                //---- textArea3 ----
                textArea3.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 16));
                textArea3.setTabSize(0);
                textArea3.setLineWrap(true);
                textArea3.setRows(44);
                textArea3.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        textArea1KeyPressed(e);
                    }
                });
                scrollPane2.setViewportView(textArea3);
            }
            panel2.add(scrollPane2, "cell 32 7 10 15,grow");

            //---- radioButton1 ----
            radioButton1.setText("A");
            panel2.add(radioButton1, "cell 1 22,aligny bottom,grow 100 0");

            //---- radioButton2 ----
            radioButton2.setText("B");
            panel2.add(radioButton2, "cell 4 22,aligny bottom,grow 100 0");

            //---- radioButton3 ----
            radioButton3.setText("C");
            panel2.add(radioButton3, "cell 7 22,aligny bottom,grow 100 0");

            //---- radioButton4 ----
            radioButton4.setText("D");
            panel2.add(radioButton4, "cell 10 22,aligny bottom,grow 100 0");

            //---- label2 ----
            label2.setText("\u9898\u76ee\u7f16\u53f7");
            panel2.add(label2, "cell 17 22");
            panel2.add(textField1, "cell 19 22 5 1");

            //---- button12 ----
            button12.setText("\u8f6c\u5230");
            button12.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button12MouseClicked(e);
                }
            });
            panel2.add(button12, "cell 26 22");

            //---- button6 ----
            button6.setText("\u4e0a\u4e00\u9898");
            button6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button6MouseClicked(e);
                }
            });
            panel2.add(button6, "cell 28 22,grow");

            //---- button7 ----
            button7.setText("\u4e0b\u4e00\u9898");
            button7.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button7MouseClicked(e);
                }
            });
            panel2.add(button7, "cell 30 22,grow");
        }
        contentPane.add(panel2, "cell 0 3 62 1");
        setSize(1000, 655);
        setLocationRelativeTo(getOwner());

        //======== this2 ========
        {
            this2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    thisMouseClicked(e);
                }
            });
            var this2ContentPane = this2.getContentPane();
            this2ContentPane.setLayout(new MigLayout(
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

            //======== scrollPane3 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {"7", "4", "7", "10", "4", "4"},
                    },
                    new String[] {
                        "\u9009\u62e9\u9898\u6570\u91cf", "\u586b\u7a7a\u9898\u6570\u91cf", "\u7b80\u7b54\u9898\u6570\u91cf", "1~3\u96be\u5ea6", "4~7\u96be\u5ea6", "8~10\u96be\u5ea6"
                    }
                ));
                {
                    TableColumnModel cm = table1.getColumnModel();
                    cm.getColumn(0).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "7"
                        }))));
                }
                scrollPane3.setViewportView(table1);
            }
            this2ContentPane.add(scrollPane3, "cell 19 4 46 3,grow");

            //---- button14 ----
            button14.setText("\u8fd4\u56de");
            this2ContentPane.add(button14, "cell 66 16");
            this2.setSize(665, 554);
            this2.setLocationRelativeTo(this2.getOwner());
        }

        //======== this3 ========
        {
            this3.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    thisMouseClicked(e);
                }
            });
            var this3ContentPane = this3.getContentPane();
            this3ContentPane.setLayout(new MigLayout(
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

            //======== scrollPane4 ========
            {

                //---- table2 ----
                table2.setModel(new DefaultTableModel(
                    new Object[][] {
                        {"\u738b\u5c0f\u4e8c", "115"},
                        {"\u5b66\u751f2", "11112"},
                        {"\u674e\u56db", "11111"},
                    },
                    new String[] {
                        "\u59d3\u540d", "\u5b66\u53f7"
                    }
                ));
                scrollPane4.setViewportView(table2);
            }
            this3ContentPane.add(scrollPane4, "cell 19 4 46 3,grow");

            //---- button15 ----
            button15.setText("\u8fd4\u56de");
            this3ContentPane.add(button15, "cell 66 16");
            this3.setSize(665, 554);
            this3.setLocationRelativeTo(this3.getOwner());
        }

        //======== this4 ========
        {
            var this4ContentPane = this4.getContentPane();
            this4ContentPane.setLayout(new MigLayout(
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

            //---- label7 ----
            label7.setText("\u67e5\u8be2\u6210\u7ee9");
            label7.setHorizontalAlignment(SwingConstants.CENTER);
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 13f));
            this4ContentPane.add(label7, "cell 7 0 8 1,grow");

            //======== scrollPane5 ========
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
                scrollPane5.setViewportView(list1);
            }
            this4ContentPane.add(scrollPane5, "cell 3 1 13 2");

            //---- button16 ----
            button16.setText("\u786e\u5b9a");
            this4ContentPane.add(button16, "cell 19 2");
            this4.setSize(515, 375);
            this4.setLocationRelativeTo(this4.getOwner());
        }

        //---- buttonGroup2 ----
        var buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(checkBox1);
        buttonGroup2.add(checkBox2);
        buttonGroup2.add(checkBox3);

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
    private JButton button2;
    private JButton button4;
    private JButton button3;
    private JButton button1;
    private JButton button5;
    private JButton button8;
    private JLabel label1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton button9;
    private JButton button10;
    private JButton button13;
    private JButton button11;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JLabel label3;
    private JComboBox<String> comboBox1;
    private JLabel label4;
    private JLabel label6;
    private JTextField textField2;
    private JLabel label5;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JScrollPane scrollPane2;
    private JTextArea textArea3;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JLabel label2;
    private JTextField textField1;
    private JButton button12;
    private JButton button6;
    private JButton button7;
    private JFrame this2;
    private JScrollPane scrollPane3;
    private JTable table1;
    private JButton button14;
    private JFrame this3;
    private JScrollPane scrollPane4;
    private JTable table2;
    private JButton button15;
    private JFrame this4;
    private JLabel label7;
    private JScrollPane scrollPane5;
    private JList<String> list1;
    private JButton button16;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
