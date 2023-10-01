package 字符串.最长单词;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(0, s.length() - 1);
        String[] s1 = s.split(" ");
        int max = 0;
        String s2 = "";
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].length() > max) {
                max = s1[i].length();
                s2 = s1[i];
            }
        }
        System.out.println(s2);
    }
}
