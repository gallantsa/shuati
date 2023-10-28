package 动态规划._46最大子序和._53_最大子序和;

public class Main {
}

class Solution {
    // 动规五部曲
    // 1. 确定dp数组以及下标的含义: dp[i]的含义是以nums[i]结尾的最大子序和
    // 2. 确定递推公式: dp[i] = max(nums[i], dp[i-1] + nums[i])
    // 3. dp数组如何初始化: dp[0] = nums[0]
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 举例推导dp数组
    public int maxSubArray(int[] nums) {
       int len = nums.length;
        int[] dp = new int[len];

        // 初始化
        dp[0] = nums[0];

        // 记录最大子序和
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            // 更新最大子序和
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}