package 循环语句.连续奇数的和2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x, y;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (x - y > 0) {
                int t = x;
                x = y;
                y = t;
            }
            int sum = 0;
            for (int j = x + 1; j < y; j++) {
                if (Math.abs(j) % 2 == 1) sum += j;
            }
            System.out.println(sum);
        }
    }
}
