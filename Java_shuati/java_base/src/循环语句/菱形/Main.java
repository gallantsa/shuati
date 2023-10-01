package 循环语句.菱形;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = n / 2;
        int y = n - x;
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= y - i; j++) {
                System.out.printf(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf(" ");
            }
            for (int j = 2 * (x - i + 1) - 1; j > 0; j--) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
