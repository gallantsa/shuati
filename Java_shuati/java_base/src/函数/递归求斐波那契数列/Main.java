package 函数.递归求斐波那契数列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fib(n));
    }

    static int fib(int n) {
        if(n == 1 || n == 2) return 1;
        else return fib(n - 1) + fib(n - 2);
    }
}
