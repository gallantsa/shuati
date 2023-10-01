package 循环语句.递增序列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        while (true) {
            x = sc.nextInt();
            if (x == 0) return;
            for (int i = 1; i <= x; i++) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}
