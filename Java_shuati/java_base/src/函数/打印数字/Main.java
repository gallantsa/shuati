package 函数.打印数字;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        print(a, size);
    }
    static void print(int[] a, int size) {
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", a[i]);
        }
    }
}
