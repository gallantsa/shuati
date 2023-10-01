package 数组.平方矩阵I;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            n = sc.nextInt();
            if (n == 0) return;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = Math.min(i + 1, n - i);
                    int y = Math.min(j + 1, n - j);
                    int z = Math.min(x, y);
                    System.out.printf("%d ", z);
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}
