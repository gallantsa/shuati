package 判断语句.游戏时间2;

import java.util.Scanner;

/**
*@author 王伟立
*@version 1.0
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int x = a * 60 + b, y = c * 60 + d;

        int min;
        if (x < y) min = y - x;
        else min = 24 * 60 - x + y;

        x = min / 60;
        y = min % 60;

        System.out.println("O JOGO DUROU "+ x + " HORA(S) E " + y + " MINUTO(S)");
    }
}
