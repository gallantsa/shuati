package _15动态规划._300_最长递增子序列;

import java.util.Arrays;

public class Main {
}

class Solution {
    // 动态规划
    // dp[i]表示以nums[i]结尾的最长递增子序列的长度
    // dp[i] = max(dp[j] + 1, dp[i])
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        // 初始化
        Arrays.fill(dp, 1);

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 遍历nums[i]之前的元素
            for (int j = 0; j < i; j++) {
                // 状态转移方程
                // dp[i]表示以nums[i]结尾的最长递增子序列的长度
                // dp[j]表示以nums[j]结尾的最长递增子序列的长度
                // dp[i] = max(dp[j] + 1, dp[i])
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        // 遍历dp数组, 找出最大值
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}