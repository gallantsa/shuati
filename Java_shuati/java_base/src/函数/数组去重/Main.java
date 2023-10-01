package 函数.数组去重;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(get_unique_count(a, n));
    }

    static int get_unique_count(int[] a, int n) {
        int sum = 1;
        Arrays.sort(a);
        for (int i = 0, j = i + 1; j < n && i < n; j++) {
            if (a[i] != a[j]) {
                sum++;
                i = j;
            }
        }
        return sum;
    }
}
