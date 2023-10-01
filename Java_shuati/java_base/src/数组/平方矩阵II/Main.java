package 数组.平方矩阵II;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            n = sc.nextInt();
            if (n == 0) break;
            int[][] q = new int[n][n];
            int m;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m = Math.abs(i - j) + 1;
                    q[i][j] = m;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ", q[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
