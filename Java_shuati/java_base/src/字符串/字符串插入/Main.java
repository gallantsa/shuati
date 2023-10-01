package 字符串.字符串插入;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, substr;
        while (sc.hasNext()) {
            str = sc.next();
            substr = sc.next();
            char max = str.charAt(0);
            int index = 0;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) > max) {
                    max = str.charAt(i);
                    index = i;
                }
            }
            String newStr = str.substring(0, index + 1) + substr + str.substring(index + 1, str.length());
            System.out.println(newStr);
        }
    }
}
