package 循环语句.最大数和它的位置;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int index = 1;
        int y;

        for (int i = 2; i <= 100; i++){
            y = sc.nextInt();
            if (y > max) {
                max = y;
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}
