package 字符串.字符串移位包含问题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        boolean flag = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.substring(0, s2.length()).equals(s2)) {
                flag = true;
                break;
            }
            s1 = s1.substring(1, s1.length()) + s1.charAt(0);
        }
        System.out.println(flag);
    }
}
