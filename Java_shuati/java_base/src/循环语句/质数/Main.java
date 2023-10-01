package 循环语句.质数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x;
        while (n-- != 0) {
            x = sc.nextInt();
            boolean flag = true;
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println(x + " is prime");
            else System.out.println(x + " is not prime");
        }
    }
}
