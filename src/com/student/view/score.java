package com.student.view;

import javax.swing.table.*;
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
    String[][] strings;
    public score(String[][] strings) {
        this.strings=strings;
        initComponents();

    }

    private void button6MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void button7MouseClicked(MouseEvent e) {
        // TODO add your code here
    }
    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        this.setVisible(false);
    }
    private void thisMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();

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

        //======== scrollPane2 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"", null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "\u8bd5\u9898\u7f16\u53f7", "\u8bd5\u9898\u540d\u79f0", "\u603b\u5206", "\u4e00\u5377", "\u4e8c\u5377"
                }
            ));
            table1.setModel(new DefaultTableModel(
                    strings,
                    new String[] {
                            "\u8bd5\u9898\u7f16\u53f7", "\u8bd5\u9898\u540d\u79f0", "\u603b\u5206", "\u4e00\u5377", "\u4e8c\u5377"
                    }
            ));
            scrollPane2.setViewportView(table1);
        }
        contentPane.add(scrollPane2, "cell 19 4 46 3,grow");

        //---- button1 ----
        button1.setText("\u8fd4\u56de");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });
        contentPane.add(button1, "cell 66 16");
        setSize(940, 665);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane2;
    private JTable table1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
