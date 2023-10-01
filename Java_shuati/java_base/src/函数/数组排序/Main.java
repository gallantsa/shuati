package 函数.数组排序;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt(), r = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        sort(a, l, r);
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
    }

    static void sort(int[] a, int l, int r) {
        int ll = r - l + 1;
        int[] b = new int[ll];
        for (int i = l, j = 0; i <= r; i++, j++) {
            b[j] = a[i];
        }
        Arrays.sort(b);
        for (int i = l, j = 0; i <= r; i++, j++) {
            a[i] = b[j];
        }
    }
}
