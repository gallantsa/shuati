package 循环语句.余数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 2; i < 10000; i++) {
            if (i % n == 2) {
                System.out.println(i);
            }
        }
    }
}
