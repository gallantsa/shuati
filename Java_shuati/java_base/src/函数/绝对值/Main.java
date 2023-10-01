package 函数.绝对值;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(abs(x));
    }

    static int abs(int x) {
        return x > 0 ? x : -x;
    }
}
