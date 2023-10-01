package 函数.递归求阶乘;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fn(n));
    }
    static int fn(int n) {
        if (n == 1) return 1;
        else return fn(n - 1) * n;
    }
}
