package 动态规划._30打家劫舍II._213_打家劫舍II;

import java.util.Arrays;

public class Main {
}

class Solution {
    // 这题与打家劫舍I的区别在于: 本题的房子是环形的, 即第一个房子和最后一个房子是相邻的
    // 只需要考虑两种情况:
    // 1. 偷第一个房子, 不偷最后一个房子
    // 2. 不偷第一个房子, 偷最后一个房子
    // 两种情况取最大值即可
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        // Arrays.copyOfRange(nums, 0, len - 1) 表示的是从nums数组中截取[0, len - 1)的元素
        return Math.max(robAction(Arrays.copyOfRange(nums, 0, len - 1)), robAction(Arrays.copyOfRange(nums, 1,
                len)));
    }

    public int robAction(int[] nums) {
        if (nums.length == 1) return nums[0];
        // 初始化
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // 注意这里的dp[i]表示的是前i个房子(包含第i个房子)能偷窃到的最大金额
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}