package 循环语句.完全数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            int sum = -x;
            for (int j = 1; j * j <= x; j++) {
                if (x % j == 0) {
                    sum += j;
                    if (j != x / j) sum += x / j;
                }
            }
            if (sum == x) System.out.println(x + " is perfect");
            else System.out.println(x + " is not perfect");
        }
    }
}
