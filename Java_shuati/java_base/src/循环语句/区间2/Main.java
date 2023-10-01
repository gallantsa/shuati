package 循环语句.区间2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = 0;
        int out = 0;
        int n = sc.nextInt();
        int x;
        for (int i = 1; i <= n; i++) {
            x = sc.nextInt();
            if (x >= 10 && x <= 20) in++;
            else out++;
        }
        System.out.println(in + " in");
        System.out.println(out + " out");
    }
}
