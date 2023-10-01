package 字符串.循环相克令;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String a;
        String b;
        while (t-- != 0) {
            a = sc.next();
            b = sc.next();
            if (a.equals(b)) {
                System.out.println("Tie");
                continue;
            }
            if ((a.equals("Hunter") && b.equals("Gun")) || (a.equals("Gun") && b.equals("Bear")) || (a.equals("Bear") && b.equals("Hunter"))) System.out.println("Player1");
            else System.out.println("Player2");

        }
    }
}
