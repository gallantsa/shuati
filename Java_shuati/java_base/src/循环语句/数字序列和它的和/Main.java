package 循环语句.数字序列和它的和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        while (true) {
            m = sc.nextInt();
            n = sc.nextInt();

            if (m <= 0 || n <= 0) return;
            if (m > n) {
                int t = m;
                m = n;
                n = t;
            }
            int sum = 0;
            for (int i = m; i <= n; i++) {
                System.out.printf("%d ", i);
                sum += i;
            }
            System.out.println("Sum=" + sum);
        }
    }
}
