package com.teacher.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.common.Message;
import com.common.MsgType;
import com.server.ManageThread;
import com.student.tool.ClientToServerThread;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Apr 11 23:31:16 CST 2021
 */


/**
 * @author Brainrain
 */
public class teacher extends JFrame  {
    private String name;
    private String ownerId;
    public static void main(String[] args) {
        teacher teacher1= new teacher("1","1");
        teacher1.setVisible(true);
    }
    public teacher(String name,String ownerId) {
        this.ownerId=ownerId;
        this.name=name;
        //this.addWindowListener(this);
        initComponents();
        label1.setText(name);
    }

    private void button2MouseEntered(MouseEvent e) {
        // TODO add your code here

    }

    private void textArea1KeyPressed(KeyEvent e) {
        // TODO add your code here
        if(e.getKeyCode()==10)
            textArea1.append("\r");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        button2 = new JButton();
        button4 = new JButton();
        button3 = new JButton();
        button1 = new JButton();
        button5 = new JButton();
        label1 = new JLabel();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();

        //======== this ========
        setTitle("\u6559\u5e08\u7aef");
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
                "[]"));

            //---- button2 ----
            button2.setText("\u7ec4\u5377");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button2MouseEntered(e);
                }
            });
            panel1.add(button2, "cell 2 0");

            //---- button4 ----
            button4.setText("\u8003\u8bd5");
            panel1.add(button4, "cell 5 0");

            //---- button3 ----
            button3.setText("\u9605\u5377");
            panel1.add(button3, "cell 8 0");

            //---- button1 ----
            button1.setText("\u5b66\u751f");
            panel1.add(button1, "cell 11 0");

            //---- button5 ----
            button5.setText("\u6210\u7ee9");
            panel1.add(button5, "cell 14 0");

            //---- label1 ----
            label1.setText("\u6b64\u5904\u663e\u793a\u59d3\u540d");
            label1.setHorizontalAlignment(SwingConstants.RIGHT);
            panel1.add(label1, "cell 17 0 7 1");
        }
        contentPane.add(panel1, "cell 0 0 62 1,grow");

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
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
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
                "[]"));

            //======== scrollPane1 ========
            {

                //---- textArea1 ----
                textArea1.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 16));
                textArea1.setTabSize(0);
                textArea1.setLineWrap(true);
                textArea1.setRows(22);
                textArea1.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        textArea1KeyPressed(e);
                    }
                });
                scrollPane1.setViewportView(textArea1);
            }
            panel2.add(scrollPane1, "cell 0 0 35 20,aligny top,grow 100 0");

            //---- radioButton1 ----
            radioButton1.setText("A");
            panel2.add(radioButton1, "cell 1 20");

            //---- radioButton2 ----
            radioButton2.setText("B");
            panel2.add(radioButton2, "cell 4 20");

            //---- radioButton3 ----
            radioButton3.setText("C");
            panel2.add(radioButton3, "cell 7 20");

            //---- radioButton4 ----
            radioButton4.setText("D");
            panel2.add(radioButton4, "cell 10 20");
        }
        contentPane.add(panel2, "cell 0 2 62 1");
        setSize(860, 600);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JButton button2;
    private JButton button4;
    private JButton button3;
    private JButton button1;
    private JButton button5;
    private JLabel label1;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
