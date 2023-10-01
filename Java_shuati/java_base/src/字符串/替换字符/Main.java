package 字符串.替换字符;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = sc.next().charAt(0);
        str = str.replace(ch, '#');
        System.out.println(str);
    }
}
