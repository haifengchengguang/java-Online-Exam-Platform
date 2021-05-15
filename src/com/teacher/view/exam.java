package com.teacher.view;

import javax.swing.*;

import com.server.dao;
import net.miginfocom.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
 * Created by JFormDesigner on Mon May 10 20:07:30 CST 2021
 */



/**
 * @author Brainrain
 */
public class exam extends JFrame {
    String[] selectexamidarray;
    String[] selectstudentarray;
    String[] examidarray;
    String[] studentarray;
    int selectedexamid;
    int lenth=0;
    public exam(String[] examidarray,String[] studentarray) {
        this.examidarray=examidarray;
        this.studentarray=studentarray;
        selectstudentarray=new String[100];


        initComponents();
        list1.setModel(new AbstractListModel<String>() {
            String[] values = examidarray;
            @Override
            public int getSize() { return values.length; }
            @Override
            public String getElementAt(int i) { return values[i]; }
        });
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i= Integer.parseInt(list1.getSelectedValue());
                selectedexamid=i;
            }
        });
        list2.setModel(new AbstractListModel<String>() {
            String[] values = studentarray;
            @Override
            public int getSize() { return values.length; }
            @Override
            public String getElementAt(int i) { return values[i]; }
        });
        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String str=list2.getSelectedValue();
                selectstudentarray[lenth]=str;
                lenth++;
                //setBackground(Color.yellow);
            }
        });
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        String examname=textField2.getText();
        int time= Integer.parseInt(textField1.getText());
        dao dao=new dao();
        dao.daoupdateExam(selectedexamid,examname,time);
        for (int i=0;i<lenth;i++)
        {
            dao.setstuexampaper(selectedexamid, Integer.parseInt(selectstudentarray[i]));
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label3 = new JLabel();
        label4 = new JLabel();
        scrollPane2 = new JScrollPane();
        list2 = new JList<>();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        label2 = new JLabel();
        textField2 = new JTextField();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
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
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]" +
            "[]" +
            "[]0" +
            "[]0" +
            "[]0" +
            "[]" +
            "[]" +
            "[]"));

        //---- label3 ----
        label3.setText("\u8bd5\u5377\u7f16\u53f7");
        contentPane.add(label3, "cell 1 1");

        //---- label4 ----
        label4.setText("\u8003\u8bd5\u5b66\u751f");
        contentPane.add(label4, "cell 19 1");

        //======== scrollPane2 ========
        {

            //---- list2 ----
            list2.setVisibleRowCount(40);
            list2.setModel(new AbstractListModel<String>() {
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
            scrollPane2.setViewportView(list2);
        }
        contentPane.add(scrollPane2, "cell 18 2 15 32,grow");

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setVisibleRowCount(40);
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
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, "cell 0 2 18 32,grow");

        //---- label2 ----
        label2.setText("\u8bd5\u9898\u540d");
        contentPane.add(label2, "cell 3 40");
        contentPane.add(textField2, "cell 5 40 4 1");

        //---- label1 ----
        label1.setText("\u8003\u8bd5\u65f6\u957f(\u5206\u949f)");
        contentPane.add(label1, "cell 13 40");
        contentPane.add(textField1, "cell 15 40 7 1");

        //---- button1 ----
        button1.setText("\u53d1\u51fa\u8003\u8bd5");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 28 40");
        setSize(660, 495);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label3;
    private JLabel label4;
    private JScrollPane scrollPane2;
    private JList<String> list2;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
