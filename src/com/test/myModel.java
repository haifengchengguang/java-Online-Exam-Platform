package com.test;

import javax.swing.*;
import java.util.ArrayList;

public class myModel extends DefaultListModel {
    public myModel(ArrayList arrayList)
    {
        for (int i=0;i<arrayList.size();i++)
        {
            addElement(arrayList.get(i));
        }
    }
}
