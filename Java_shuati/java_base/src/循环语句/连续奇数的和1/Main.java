package 循环语句.连续奇数的和1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (x > y) {
            int t = x;
            x = y;
            y = t;
        }
        int sum = 0;
        for (int i = x + 1; i < y; i++) {
            if (Math.abs(i) % 2 == 1) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
