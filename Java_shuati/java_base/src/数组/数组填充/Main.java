package 数组.数组填充;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int[] q = new int[10];
        q[0] = v;
        for (int i = 1; i < 10; i++) {
            q[i] = q[i - 1] * 2;
        }
        for (int i = 0; i < 10; i++) {
            System.out.printf("N[%d] = %d\n", i, q[i]);
        }

    }
}
