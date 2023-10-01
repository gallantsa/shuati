package 数组.数组选择;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] a = new double[100];
        for (int i = 0; i < 100; i++) {
            a[i] = sc.nextDouble();
            if(a[i] <= 10) System.out.printf("A[%d] = %.1f\n", i, a[i]);
        }

    }
}
