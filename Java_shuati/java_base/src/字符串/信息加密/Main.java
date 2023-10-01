package 字符串.信息加密;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                System.out.printf("%c", 'a' + (str.charAt(i) - 'a' + 1) % 26);
            } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                System.out.printf("%c", 'A' + (str.charAt(i) - 'A' + 1) % 26);
            } else {
                System.out.printf("%c", str.charAt(i));
            }
        }
    }
}
