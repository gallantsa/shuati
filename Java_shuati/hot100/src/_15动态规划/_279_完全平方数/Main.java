package _15动态规划._279_完全平方数;

import java.util.Arrays;

public class Main {
}

class Solution {
    // 动态规划
    // dp[i]表示数字i最少可以由多少个完全平方数组成
    // dp[i] = min(dp[i - j * j] + 1, dp[i])
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        // 初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 遍历数字
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // 状态转移方程
                // dp[i]表示数字i最少可以由多少个完全平方数组成
                // dp[i - j * j]表示数字i - j * j最少可以由多少个完全平方数组成
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];
    }
}