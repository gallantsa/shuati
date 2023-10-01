package 字符串.字符串中最长的连续出现的字符;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- != 0) {
            String s = sc.next();
            char rc = ' ';
            int cnt = 0;
            for (int i = 0, j = i + 1; i < s.length();) {
                while (j < s.length() && s.charAt(i) == s.charAt(j)) j++;
                if (j - i > cnt) {
                    cnt = j - i;
                    rc = s.charAt(i);
                }
                i = j;
            }
            System.out.printf("%c %d\n", rc, cnt);
        }
    }
}
