package 动态规划._4使用最小花费爬楼梯._746_使用最小花费爬楼梯;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cost = { 10, 15, 20 };
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}

class Solution {
    // 动态规划五部曲
    // 1. 确定dp[i]的含义: 到达第i个台阶的花费为dp[i]
    // 2. 确定递推公式: dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
    // 3. dp数组如何初始化: dp[0] = 0, dp[1] = 0
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 打印dp数组: 不需要打印
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[cost.length];
    }
}