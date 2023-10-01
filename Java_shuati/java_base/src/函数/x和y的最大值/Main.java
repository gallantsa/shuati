package 函数.x和y的最大值;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        System.out.println(max(x, y));
    }

    static int max(int x, int y) {
        return x > y ? x : y;
    }
}
