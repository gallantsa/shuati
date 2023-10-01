package 字符串.字符串匹配;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double k = sc.nextDouble();
        String a = sc.next();
        String b = sc.next();
        int sum = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) sum++;
        }
        double p = 1.0 * sum / a.length();
        if (p >= k) System.out.println("yes");
        else System.out.println("no");
    }
}
