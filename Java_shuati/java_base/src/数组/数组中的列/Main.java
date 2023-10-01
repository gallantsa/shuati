package 数组.数组中的列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        char c = sc.next().charAt(0);
        double[][] m = new double[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                m[i][j] = sc.nextDouble();
            }
        }
        double sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += m[i][l];
        }
        if (c == 'S') {
            System.out.printf("%.1f", sum);
        } else if (c == 'M') {
            System.out.printf("%.1f", sum / 12);
        }
    }
}
