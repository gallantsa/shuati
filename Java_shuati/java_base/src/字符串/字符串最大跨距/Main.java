package 字符串.字符串最大跨距;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] ss = str.split(",");
        String s = ss[0];
        String s1 = ss[1];
        String s2 = ss[2];
        int i = s.indexOf(s1) + s1.length() - 1;
        int j = s.lastIndexOf(s2);
        if (s.indexOf(s1) != -1 && s.lastIndexOf(s2) != -1 && j > i) System.out.println(j - i - 1);
        else System.out.println(-1);

    }
}
