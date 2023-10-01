package 函数.两个数的和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        System.out.printf("%.2f", add(x, y));
    }
    static double add(double x, double y) {
        return x + y;
    }
}
