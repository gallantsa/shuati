package 循环语句.PUM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = (i - 1) * m + 1, k = 1; k <= m; k++, j++) {
                if (j % m != 0) System.out.printf("%d ", j);
                else System.out.println("PUM");
            }
        }
    }
}
