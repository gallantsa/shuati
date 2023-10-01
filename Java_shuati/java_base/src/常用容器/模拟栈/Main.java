package 常用容器.模拟栈;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Stack<Integer> stk = new Stack<>();

        while(m -- != 0) {
            String str = sc.next();
            if (str.equals("push")) {
                stk.push(sc.nextInt());
            } else if (str.equals("pop")) {
                stk.pop();
            } else if (str.equals("empty")) {
                if(stk.empty()) System.out.println("YES");
                else System.out.println("NO");
            } else if (str.equals("query")) {
                System.out.println(stk.peek());
            }
        }
    }
}
