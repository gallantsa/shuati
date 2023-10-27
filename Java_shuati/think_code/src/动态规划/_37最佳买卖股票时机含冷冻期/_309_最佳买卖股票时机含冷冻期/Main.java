package 动态规划._37最佳买卖股票时机含冷冻期._309_最佳买卖股票时机含冷冻期;

public class Main {
}

class Solution {
    // 本题有四种状态:
    // 0: 持有股票
    // 1: 保持卖出股票
    // 2: 卖出股票
    // 3: 冷冻期
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;

        int[][] dp = new int[len][4];

        dp[0][0] = - prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        for (int i = 1; i < len; i++) {
            // 如果第i天持有股票, 那么第i - 1天就有两种状态: 1. 第i - 1天就持有股票, 2. 第i - 1天不持有股票, 第i天买入股票 3. 第i - 1天为冷冻期, 第i天买入股票
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            // 如果第i天不持有股票, 那么第i - 1天就有两种状态: 1. 第i - 1天就不持有股票, 2. 第i - 1天为冷冻期
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            // 如果第i天卖出股票, 那么第i - 1天一定持有股票
            dp[i][2] = dp[i - 1][0] + prices[i];
            // 如果第i天为冷冻期, 那么第i - 1天一定卖出股票
            dp[i][3] = dp[i - 1][2];
        }
        // 最大利润一定是不持有股票的时候
        return Math.max(dp[len - 1][1], Math.max(dp[len - 1][2], dp[len - 1][3]));
    }
}