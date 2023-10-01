package 数组.数组替换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] q = new int[10];
        for (int i = 0; i < 10; i++) {
            q[i] = sc.nextInt();
            if (q[i] <= 0) q[i] = 1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.printf("X[%d] = %d\n", i, q[i]);
        }
    }
}
