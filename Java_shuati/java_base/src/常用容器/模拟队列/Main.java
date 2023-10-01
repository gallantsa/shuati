package 常用容器.模拟队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        while(m-- != 0) {
            String str = sc.next();
            if (str.equals("push")){
                queue.add(sc.nextInt());
            } else if (str.equals("pop")) {
                queue.remove();
            } else if (str.equals("empty")) {
                if (queue.isEmpty()) System.out.println("YES");
                else System.out.println("NO");
            } else if (str.equals("query")) {
                System.out.println(queue.peek());
            }
        }
    }
}
