package com.teacher.view;

import javax.swing.*;

import com.server.dao;
import com.test.myModel;
import net.miginfocom.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Wed May 12 21:13:49 CST 2021
 */



/**
 * @author Brainrain
 */
public class yuejuan extends JFrame {
    //myModel model;
    String[] strings;
    public yuejuan(String[] strings) {
        this.strings=strings;
        //this.model=model;
        initComponents();
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
                int i=list1.getSelectedIndex();
                int examid1= Integer.parseInt(list1.getSelectedValue());
                ArrayList num;
                String[] strings1;
                dao dao=new dao();
                num=dao.getstuexam(examid1);
                myModel modelq=new myModel(num);
                strings1=dao.getstuexamuid(examid1);
                stu stu=new stu(strings1,examid1);
                stu.setVisible(true);
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        button1 = new JButton();

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

        //---- label1 ----
        label1.setText("\u9009\u62e9\u6279\u9605\u8bd5\u9898");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 13f));
        contentPane.add(label1, "cell 7 0 8 1,grow");

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setVisibleRowCount(34);
            list1.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "item1",
                    "item2",
                    "item3"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, "cell 3 1 13 2");

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        contentPane.add(button1, "cell 19 2");
        setSize(515, 375);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
