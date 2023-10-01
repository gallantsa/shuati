package 判断语句.一元二次方程公式;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double R1;
        double R2;

        double delta = b * b - 4 * a * c;

        R1 = (-b + Math.sqrt(delta)) / (2 * a);
        R2 = (-b - Math.sqrt(delta)) / (2 * a);

        if (delta >= 0 && a != 0) {
            System.out.printf("R1 = %.5f\n", R1);
            System.out.printf("R2 = %.5f\n", R2);
        } else {
            System.out.println("Impossivel calcular");
        }
    }
}
