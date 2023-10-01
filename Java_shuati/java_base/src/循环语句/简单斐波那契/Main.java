package 循环语句.简单斐波那契;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", a);
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
