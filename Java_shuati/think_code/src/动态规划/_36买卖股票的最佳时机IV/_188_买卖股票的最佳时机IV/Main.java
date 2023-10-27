package 动态规划._36买卖股票的最佳时机IV._188_买卖股票的最佳时机IV;

public class Main {
}

class Solution {
    // 上一题的拓展, 本题的状态有2 * k + 1种
    // 0: 不进行任何操作
    // 1: 第一次买入股票
    // 2: 第一次卖出股票
    // 3: 第二次买入股票
    // 4: 第二次卖出股票
    // ...
    // 2 * k - 1: 第k次买入股票
    // 2 * k: 第k次卖出股票
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 1) return 0;
        int len = prices.length;
        int[][] dp = new int[len][2 * k + 1];

        // 初始化
        for (int i = 1; i <= 2 * k; i += 2) {
            dp[0][i] = - prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= 2 * k - 1; j += 2) {
                // 注意这里的dp[i][j]表示的是第i天持有股票时的最大利润, 动态的看这句代码
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                // 注意这里的dp[i][j + 1]表示的是第i天不持有股票时的最大利润
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], prices[i] + dp[i - 1][j + 1]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}