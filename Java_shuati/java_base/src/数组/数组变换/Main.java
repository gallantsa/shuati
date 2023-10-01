package 数组.数组变换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[20];
        for (int i = 0; i < n.length; i++) {
            n[i] = sc.nextInt();
        }
        int t;
        for (int i = 0; i < n.length / 2; i++) {
            t = n[i];
            n[i] = n[n.length - i - 1];
            n[n.length - i - 1] = t;
        }
        for (int i = 0; i < n.length; i++) {
            System.out.printf("N[%d] = %d\n", i, n[i]);
        }
    }
}
