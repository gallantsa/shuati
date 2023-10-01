package 字符串.输出字符串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        for (int i = 0; i < a.length(); i++) {
            System.out.printf("%c", a.charAt(i) + a.charAt((i + 1) % a.length()));
        }
    }
}
