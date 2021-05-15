package com.teacher.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
 * Created by JFormDesigner on Mon May 10 00:28:28 CST 2021
 */


/**
 * @author Brainrain
 */
public class score extends JFrame {
    public score() {
        initComponents();
    }

    private void button6MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button7MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void thisMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        scrollPane3 = new JScrollPane();
        textArea2 = new JTextArea();
        label1 = new JLabel();
        textField1 = new JTextField();
        button6 = new JButton();
        button7 = new JButton();
        button1 = new JButton();
        this2 = new JFrame();
        label2 = new JLabel();
        scrollPane4 = new JScrollPane();
        list2 = new JList();
        button2 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMouseClicked(e);
            }
        });
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
        contentPane.add(scrollPane1, "cell 2 3 41 2,grow");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table1);
        }
        contentPane.add(scrollPane2, "cell 49 3 21 3,grow");

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
        contentPane.add(scrollPane3, "cell 2 5 41 1,grow");

        //---- label1 ----
        label1.setText("\u8be5\u9898\u5f97\u5206");
        contentPane.add(label1, "cell 26 8");

        //---- textField1 ----
        textField1.setText("\u9605\u5377\u7684\u65f6\u5019\u53ef\u7f16\u8f91\uff0c\u67e5\u770b\u6210\u7ee9\u7684\u65f6\u5019\u4e0d\u53ef\u7f16\u8f91");
        contentPane.add(textField1, "cell 27 8 16 1");

        //---- button6 ----
        button6.setText("\u4e0a\u4e00\u9898");
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button6MouseClicked(e);
            }
        });
        contentPane.add(button6, "cell 32 16,grow");

        //---- button7 ----
        button7.setText("\u4e0b\u4e00\u9898");
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button7MouseClicked(e);
            }
        });
        contentPane.add(button7, "cell 33 16,grow");

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        contentPane.add(button1, "cell 65 16");
        setSize(940, 665);
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

            //---- label2 ----
            label2.setText("\u9009\u62e9\u67e5\u770b\u8bd5\u9898");
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 13f));
            this2ContentPane.add(label2, "cell 7 0 8 1,grow");

            //======== scrollPane4 ========
            {

                //---- list2 ----
                list2.setVisibleRowCount(34);
                scrollPane4.setViewportView(list2);
            }
            this2ContentPane.add(scrollPane4, "cell 3 1 13 2");

            //---- button2 ----
            button2.setText("\u786e\u5b9a");
            this2ContentPane.add(button2, "cell 19 2");
            this2.setSize(515, 375);
            this2.setLocationRelativeTo(this2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JScrollPane scrollPane3;
    private JTextArea textArea2;
    private JLabel label1;
    private JTextField textField1;
    private JButton button6;
    private JButton button7;
    private JButton button1;
    private JFrame this2;
    private JLabel label2;
    private JScrollPane scrollPane4;
    private JList list2;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
