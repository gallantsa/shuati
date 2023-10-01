package 字符串.只出现一次的字符;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int first = 0, last = 0;
        for (int i = 0; i < str.length(); i++) {
            first = str.indexOf(str.charAt(i));
            last = str.lastIndexOf(str.charAt(i));
            if (first == last) {
                System.out.println(str.charAt(i));
                return;
            }
        }
        if (first != last) System.out.println("no");
    }
}
