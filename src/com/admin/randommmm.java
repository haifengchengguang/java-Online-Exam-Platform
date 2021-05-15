package com.admin;

import java.util.Random;

public class randommmm {


    public static void main(String[] args) {
        //1后端
        //2产品
        Random r = new Random();
        int i1 = r.nextInt(1)+1; // 生成[0,10]区间的整数
        if(i1==1)
        {
            System.out.println("\u540e\u7aef");
        }
        else if(i1==2)
        {
            System.out.println("\u4ea7\u54c1");
        }
    }
}
