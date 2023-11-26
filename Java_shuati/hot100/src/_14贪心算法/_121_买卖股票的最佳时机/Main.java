package _14贪心算法._121_买卖股票的最佳时机;

public class Main {
}

class Solution {
    // 贪心算法
    public int maxProfit(int[] prices) {

        // 1. 定义最大利润
        int maxProfit = 0;

        // 2. 定义最低价格
        int minPrice = Integer.MAX_VALUE;

        // 3. 遍历数组
        for (int price : prices) {

            // 4. 如果当前价格小于最低价格, 更新最低价格
            if (price < minPrice) {
                minPrice = price;
            }

            // 5. 如果当前价格减去最低价格大于最大利润, 更新最大利润
            if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        // 6. 返回最大利润
        return maxProfit;
    }
}