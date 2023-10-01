package 循环语句.正数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        for (int i = 0; i < 6; i++){
            double y = sc.nextDouble();
            if (y > 0) x++;
        }
        System.out.println(x + " positive numbers");
    }
}
