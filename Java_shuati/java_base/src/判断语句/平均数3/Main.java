package 判断语句.平均数3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        double n3 = sc.nextDouble();
        double n4 = sc.nextDouble();

        double x = n1 * 0.2 + n2 * 0.3 + n3 * 0.4 + n4 * 0.1;

        System.out.printf("Media: %.1f\n", x);

        if (x >= 7.0) {
            System.out.println("Aluno aprovado.");
        } else if ( x < 5.0) {
            System.out.println("Aluno reprovado.");
        } else {
            System.out.println("Aluno em exame.");
            double y = sc.nextDouble();
            System.out.printf("Nota do exame: %.1f\n", y);
            double z = (x + y) / 2;
            if (z >= 5.0) {
                System.out.println("Aluno aprovado.");
            } else {
                System.out.println("Aluno reprovado.");
            }
            System.out.printf("Media final: %.1f\n", z);
        }
    }
}
