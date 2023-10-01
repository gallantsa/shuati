package 数组.最小数和它的位置;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int index = 0;
        x[0] = sc.nextInt();
        int min = x[0];
        for (int i = 1; i < x.length; i++) {
            x[i] = sc.nextInt();
            if (x[i] < min) {
                min = x[i];
                index = i;
            }
        }
        System.out.printf("Minimum value: %d\n", min);
        System.out.printf("Position: %d", index);
    }
}
