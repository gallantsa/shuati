package 函数.复制数组;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int size = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        copy(a, b, size);
        for (int i = 0; i < m; i++) {
            System.out.printf("%d ", b[i]);
        }
    }

    static void copy(int[] a, int[] b, int size) {
        for (int i = 0; i < size; i++) {
            b[i] = a[i];
        }
    }
}
