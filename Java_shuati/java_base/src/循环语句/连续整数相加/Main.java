package 循环语句.连续整数相加;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        while (n <= 0) {
            n = sc.nextInt();
        }
        int sum = 0;
        for (int i = 1, j = a; i <= n; i++, j++) {
            sum += j;
        }
        System.out.println(sum);
    }
}
