package 函数.走方格;

// Todo 走方格
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(fn(n, m));
    }

    static int fn(int n, int m) {
        if (n == 0 && m == 0) return 1;
        if (n < 0 || m < 0) return 0;
        return fn(n - 1, m) + fn(n, m - 1);
    }
}
