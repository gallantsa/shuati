package 循环语句.实验;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a;
        char t;
        int sum = 0;
        int sumc = 0, sumr = 0, sumf = 0;
        double perc, perr, perf;
        for (int i = 1; i <= n; i++) {
            a = sc.nextInt();
            t = sc.next().charAt(0);
            sum += a;
            if (t == 'C') sumc += a;
            else if (t == 'R') sumr += a;
            else if (t == 'F') sumf += a;
        }
        perc = 1.0 * sumc / sum * 100;
        perr = 1.0 * sumr / sum * 100;
        perf = 1.0 * sumf / sum * 100;

        System.out.printf("Total: %d animals\n", sum);
        System.out.printf("Total coneys: %d\n", sumc);
        System.out.printf("Total rats: %d\n", sumr);
        System.out.printf("Total frogs: %d\n", sumf);
        System.out.printf("Percentage of coneys: %.2f %%\n", perc);
        System.out.printf("Percentage of rats: %.2f %%\n", perr);
        System.out.printf("Percentage of frogs: %.2f %%\n", perf);

    }
}
