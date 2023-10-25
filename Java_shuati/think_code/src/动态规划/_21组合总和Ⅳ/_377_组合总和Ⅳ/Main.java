package 动态规划._21组合总和Ⅳ._377_组合总和Ⅳ;

public class Main {
}

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;
        // 本题正好和上一题不同
        // 只能先遍历背包, 再遍历物品
        // 因为本题求的是排列数, 而上一题求的是组合数
        // 注意本题可以相当于进阶版的爬楼梯问题
        // 这样看来爬楼梯问题也是一种完全背包问题
        // 遍历背包
        for (int i = 0; i <= target; i++) {
            // 遍历物品
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }

        return dp[target];
    }
}