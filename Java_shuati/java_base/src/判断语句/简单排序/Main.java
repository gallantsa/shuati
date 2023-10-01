package 判断语句.简单排序;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = a, y = b, z = c;

        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }

        if (a > c) {
            int t = a;
            a = c;
            c = t;
        }

        if (b > c) {
            int t = b;
            b = c;
            c = t;
        }

        System.out.printf("%d\n%d\n%d\n\n", a, b, c);
        System.out.printf("%d\n%d\n%d\n", x, y, z);
    }
}
