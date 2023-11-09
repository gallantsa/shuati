package _5普通数组._53_最大子数组和;

public class Main {
}

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        // 遍历数组
        for (int num : nums) {
            // 如果sum大于0，说明对结果有增益效果，则sum保留并加上当前遍历数字
            if (sum > 0) {
                sum += num;
            } else {
                // 如果sum小于等于0，说明对结果无增益效果，需要舍弃，则sum直接更新为当前遍历数字
                sum = num;
            }
            // 比较sum和res的大小，将最大值置为res，遍历结束返回结果
            res = Math.max(res, sum);
        }
        return res;
    }

    // 动态规划
    // 状态定义：dp[i]表示以nums[i]结尾的连续子数组的最大和
    // 状态转移方程：dp[i] = max(dp[i - 1] + nums[i], nums[i])
    // 初始状态：dp[0] = nums[0]
    // 遍历方向：从前往后遍历
    public int maxSubArray2(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        // 初始化
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            // 状态转移方程
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 更新结果
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}