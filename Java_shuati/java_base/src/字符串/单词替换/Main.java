package 字符串.单词替换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String a = sc.next();
        String b = sc.next();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            if(s1[i].equals(a)) s1[i] = b;
        }
        for (int i = 0; i < s1.length; i++) {
            System.out.printf("%s ", s1[i]);
        }
    }
}
