package 动态规划._23零钱兑换._322_零钱兑换;

import java.util.Arrays;

public class Main {
}

class Solution {
    // 这里dp[i]的含义是: 凑成总金额为i的最少硬币数
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // 创建一个长度为 amount + 1 的数组 dp
        Arrays.fill(dp, Integer.MAX_VALUE); // 将 dp 数组中的所有元素初始化为最大值
        dp[0] = 0; // 初始化金额为 0 的最少硬币数为 0

        // 动态规划的核心逻辑
        // 这里先遍历物品, 再遍历背包 或者 先遍历背包, 再遍历物品都可以
        // 因为本题求的是最小值, 而不是组合数或者排列数
        for (int i = 0; i < coins.length; i++) { // 遍历硬币数组
            for (int j = coins[i]; j <= amount; j++) { // 遍历金额从 coins[i] 到 amount
                if (dp[j - coins[i]] != Integer.MAX_VALUE) { // 如果 dp[j - coins[i]] 不为最大值，说明可以通过使用 coins[i] 硬币得到金额 j
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1); // 更新 dp[j] 的最小硬币数，取当前硬币数与之前已计算的最小硬币数的较小值
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount]; // 返回金额 amount 对应的最小硬币数，如果不存在则返回 -1
    }
}