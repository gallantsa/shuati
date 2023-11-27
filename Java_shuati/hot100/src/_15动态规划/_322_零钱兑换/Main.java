package _15动态规划._322_零钱兑换;

import java.util.Arrays;

public class Main {
}

class Solution {
    // 动态规划
    // dp[i]表示凑成总金额i所需的最少的硬币个数
    // dp[i] = min(dp[i - coins[j]] + 1, dp[i])
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // 初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 遍历金额
        for (int i = 1; i <= amount; i++) {
            // 遍历硬币
            for (int j = 0; j < coins.length; j++) {
                // 状态转移方程
                // dp[i]表示凑成总金额i所需的最少的硬币个数
                // dp[i - coins[j]]表示凑成总金额i - coins[j]所需的最少的硬币个数
                // dp[i - coins[j]] != Integer.MAX_VALUE表示凑成总金额i - coins[j]有解
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}