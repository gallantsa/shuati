package 判断语句.税;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sa = sc.nextFloat();
        double taxes;
        if (sa > 0 && sa < 2000) {
            taxes = 0;
        }else if (sa > 2000.01 && sa < 3000) {
            sa -= 2000;
            taxes = sa * 0.08;
        }else if (sa > 3000.01 && sa < 4500) {
            sa -= 3000;
            taxes = sa * 0.18 + 1000 * 0.08;
        } else {
            sa -= 4500;
            taxes = sa * 0.28 + 1000 * 0.08 + 1500 * 0.18;
        }

        if (taxes != 0)
            System.out.printf("R$ %.2f", taxes);
        else
            System.out.printf("Isento");
    }
}
