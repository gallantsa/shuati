package 动态规划._39买卖股票的最佳时机含手续费._714_买卖股票的最佳时机含手续费;

public class Main {
}

class Solution {
    // 本题有两种状态:
    // 0: 持有股票
    // 1: 不持有股票
    // 本题与买卖股票的最佳时机II的区别在于, 本题有手续费, 所以在卖出股票的时候要减去手续费
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;

        int[][] dp = new int[len][2];
        dp[0][0] = - prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < len; i++) {
            // 如果第i天持有股票, 那么第i - 1天就有两种状态: 1. 第i - 1天就持有股票, 2. 第i - 1天不持有股票, 第i天买入股票
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            // 如果第i天不持有股票, 那么第i - 1天就有两种状态: 1. 第i - 1天就不持有股票, 2. 第i - 1天持有股票, 第i天卖出股票, 同时要减去手续费
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }

        return dp[len - 1][1];
    }
}