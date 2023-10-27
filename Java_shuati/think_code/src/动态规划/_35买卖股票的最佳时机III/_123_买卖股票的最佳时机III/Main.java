package 动态规划._35买卖股票的最佳时机III._123_买卖股票的最佳时机III;

public class Main {
}

class Solution {
    // 本题所表示的状态有五种
    // 0: 不进行任何操作
    // 1: 第一次买入股票
    // 2: 第一次卖出股票
    // 3: 第二次买入股票
    // 4: 第二次卖出股票
    // 动规五部曲
    // 1. 确定dp数组以及下标的含义: dp[i][j]表示第i天进行第j种操作时的最大利润
    // 2. 确定递推公式: dp[i][0] = dp[i - 1][0]
    //                dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
    //                dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i])
    //                dp[i][3] = max(dp[i - 1][3], dp[i - 1][2] - prices[i])
    //                dp[i][4] = max(dp[i - 1][4], dp[i - 1][3] + prices[i])
    // 3. dp数组如何初始化: dp[0][0] = 0, dp[0][1] = - prices[0], dp[0][2] = 0, dp[0][3] = - prices[0], dp[0][4] = 0
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 举例推导dp数组
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][5];

        // 初始化
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        dp[0][2] = 0;
        dp[0][3] = - prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}