package 贪心算法._6买卖股票的最佳时机II._122_买卖股票的最佳时机II;

public class Main {
}

class Solution {
    // 贪心算法
    // 局部最优解: 当利润大于0, 则result加上利润 利润 = 今天的价格 - 昨天的价格
    // 全局最优解: 计数的最大值
    public int maxProfit(int[] prices) {
        int money;
        int result = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            money = prices[i + 1] - prices[i];
            if (money > 0) {
                result += money;
            }
        }
        return result;
    }
}