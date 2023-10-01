package 数组.数组的上方区域;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        double[][] m = new double[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                m[i][j] = sc.nextDouble();
            }
        }
        double sum = 0;
        for (int i = 0; i <= 4; i++) {
            for (int j = i + 1; j <= 10 - i; j++) {
                sum += m[i][j];
            }
        }
        if (ch == 'S') System.out.printf("%.1f", sum);
        else if (ch == 'M') System.out.printf("%.1f", sum / 30);
    }
}
