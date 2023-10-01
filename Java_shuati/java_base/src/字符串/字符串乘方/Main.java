package 字符串.字符串乘方;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            str = sc.next();
            if (str.equals(".")) break;

            int n = str.length();
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    String r = "";
                    for (int j = 0; j < n / i; j++) {
                        r += str.substring(0, i);
                    }
                    if (r.equals(str)) {
                        System.out.println(n / i);
                        break;
                    }
                }
            }
        }
    }
}
