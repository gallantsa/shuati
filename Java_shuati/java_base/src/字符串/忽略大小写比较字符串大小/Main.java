package 字符串.忽略大小写比较字符串大小;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int c = a.compareToIgnoreCase(b);
        if ( c > 0) {
            System.out.println(">");
        } else if (c < 0) {
            System.out.println("<");
        } else {
            System.out.println("=");
        }
    }
}
