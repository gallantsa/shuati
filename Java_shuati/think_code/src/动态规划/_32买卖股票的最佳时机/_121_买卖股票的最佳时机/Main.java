package 动态规划._32买卖股票的最佳时机._121_买卖股票的最佳时机;

public class Main {
}

class Solution {
    // 动规五部曲
    // 1. 确定dp数组以及下标的含义: dp[i][j]表示第i天持有(j = 0)或不持有(j = 1)股票时的最大利润
    // 2. 确定递推公式: dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
    //                dp[i][1] = max(dp[i - 1][1], - prices[i])
    // 3. dp数组如何初始化: dp[0][0] = 0, dp[0][1] = - prices[0]
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 举例推导dp数组
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int dp[][] = new int[2][2];

        // 初始化
        dp[0][0] = - prices[0];
        dp[0][1] = 0;

        // 遍历
        // % 2 的使用是为了优化空间复杂度。在这个特定的动态规划问题中，我们只需要存储前一天的状态和当前天的状态，因为未来的状态仅依赖于前一天的状态，而不依赖于更早的状态。
        for (int i = 1; i < len; i++){
            // 注意这里的dp[i][0]表示的是第i天持有股票时的最大利润, 动态的看这句代码
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], - prices[i]);
            // 注意这里的dp[i][1]表示的是第i天不持有股票时的最大利润
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], prices[i] + dp[(i - 1) % 2][0]);
        }
        return dp[(len - 1) % 2][1];
    }
}