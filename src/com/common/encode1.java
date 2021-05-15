package com.common;

import java.util.Scanner;

public class encode1 {
    public static String encode(String s) {
        StringBuilder sb = new StringBuilder(s.length() * 3);
        for (char c : s.toCharArray()) {
            if (c < 256) {
                sb.append(c);
            } else {
                sb.append("\\u");
                sb.append(Character.forDigit((c >>> 12) & 0xf, 16));
                sb.append(Character.forDigit((c >>> 8) & 0xf, 16));
                sb.append(Character.forDigit((c >>> 4) & 0xf, 16));
                sb.append(Character.forDigit((c) & 0xf, 16));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        while (true) {
            String s;
            Scanner scanner = new Scanner(System.in);
            s = scanner.nextLine();
            String s1;
            s1 = encode(s);
            System.out.println(s1);
            System.out.println("\""+s1+"\"");
        }
    }
}
