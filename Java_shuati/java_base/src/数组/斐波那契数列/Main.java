package 数组.斐波那契数列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        int i;
        long[] fib = new long[2];
        while (t -- != 0) {
            fib[0] = 0;
            fib[1] = 1;
            long a;
            i = 0;
            n = sc.nextInt();
            while (n -- != 0) {
                a = fib[0];
                fib[0] = fib[1];
                fib[1] = a + fib[1];
                i++;
            }
            System.out.printf("Fib(%d) = %d\n", i, fib[0]);
        }
        // 0 1 1 2 3 5
    }
}
