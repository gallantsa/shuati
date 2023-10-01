package 循环语句.六个奇数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int i = 1, j = x % 2 == 1 ? x : x + 1; i <= 6; i ++, j += 2) {
            System.out.println(j);
        }
    }
}
