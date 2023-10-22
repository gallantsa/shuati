package 动态规划._2斐波那契数._509_斐波那契数;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    // 确定dp[i]的含义: dp[i]表示第i个斐波那契数
    // 递推公式: dp[i] = dp[i - 1] + dp[i - 2]
    // dp数组如何初始化: dp[0] = 0, dp[1] = 1
    // 确定遍历顺序: 从前往后遍历
    // 打印dp数组: 不需要打印
    public int fib(int n) {
        // 如果n小于2, 则直接返回n
        if (n < 2) {
            return n;
        }
        // 数组从0开始, 所以数组长度为n+1
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 状态转移方程
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 状态压缩版本
    public int fib2(int n) {
        // 如果n小于2, 则直接返回n
        if (n < 2) {
            return n;
        }
        // 由于dp[i]只和dp[i - 1]和dp[i - 2]有关, 所以只需要两个变量即可
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            // 状态转移方程
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}