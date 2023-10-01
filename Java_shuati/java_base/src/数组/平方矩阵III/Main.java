package 数组.平方矩阵III;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(true) {
            n = sc.nextInt();
            if (n == 0) return;
            int[][] q = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    q[i][j] = (int)Math.pow(2, i + j);
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
