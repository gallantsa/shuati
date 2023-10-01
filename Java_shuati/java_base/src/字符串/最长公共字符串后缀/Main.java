package 字符串.最长公共字符串后缀;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            String[] strings = new String[n];
            strings[0] = sc.next();
            int min = strings[0].length();
            for (int i = 1; i < n; i++) {
                strings[i] = sc.next();
                if (strings[i].length() < min) min = strings[i].length();
            }
            int sum = 0;
            for (int i = 0; i < min; i++) {
                boolean flag = true;
                char ch = strings[0].charAt(strings[0].length() - 1 - i);
                for (int j = 1; j < n; j++) {
                    if (strings[j].charAt(strings[j].length() - 1 - i) != ch) {
                        flag = false;
                        break;
                    }
                }
                if (flag) sum ++;
                else break;
            }
            if (sum == 0) System.out.println(" ");
            else {
                String substring = strings[0].substring(strings[0].length() - sum, strings[0].length());
                System.out.println(substring);
            }
        }
    }
}
