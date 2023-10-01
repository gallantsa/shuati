package 函数.数组翻转;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        reverse(a, size);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", a[i]);
        }
    }
    static void reverse(int[] a, int size) {
        for (int i = 0; i < size / 2; i++) {
            int temp = a[i];
            a[i] = a[size - 1 - i];
            a[size - 1 - i] = temp;
        }
    }
}
