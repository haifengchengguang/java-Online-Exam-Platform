/*
 * Created by JFormDesigner on Fri May 14 21:50:04 SGT 2021
 */

package com.teacher.view;

import javax.swing.*;
import javax.swing.table.*;
import net.miginfocom.swing.*;

/**
 * @author 555
 */
public class picture extends JFrame {
    public static void main(String[] args) {
        picture picture=new picture();
        picture.setVisible(true);
    }
    public picture() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        scrollPane4 = new JScrollPane();
        table1 = new JTable();

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
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[201]" +
            "[0]" +
            "[]" +
            "[]"));

        //---- button1 ----
        button1.setText("text");
        button1.setIcon(new ImageIcon(getClass().getResource("/com/teacher/view/picture1.png")));
        contentPane.add(button1, "cell 5 3");

        //======== scrollPane4 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"115", "96", "1"},
                    {"11116", "96", "1"},
                    {"11115", "82", "3"},
                    {"11112", "80", "4"},
                    {"11117", "76", "5"},
                    {"11113", "74", "6"},
                    {"11114", "72", "7"},
                    {"11112", "66", "8"},
                    {"11118", "48", "9"},
                },
                new String[] {
                    "\u5b66\u53f7", "\u6210\u7ee9", "\u6392\u540d"
                }
            ));
            scrollPane4.setViewportView(table1);
        }
        contentPane.add(scrollPane4, "cell 3 6 3 1,grow");
        setSize(745, 505);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JScrollPane scrollPane4;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
