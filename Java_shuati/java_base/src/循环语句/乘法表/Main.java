package 循环语句.乘法表;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x;
        for (int i = 1; i <= 10; i++) {
            x = i * n;
            System.out.println(i + " x " + n + " = " + x);
        }
    }
}
