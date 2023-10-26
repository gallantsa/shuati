package 动态规划._29打家劫舍._198_打家劫舍;

public class Main {
}

class Solution {
    // 动规五部曲
    // 1. 确定dp数组以及下标的含义: dp[i]表示前i个房子(包含第i个房子)能偷窃到的最大金额
    // 2. 确定递推公式: dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
    // 3. dp数组如何初始化: dp[0] = nums[0], dp[1] = max(nums[0], nums[1])
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 打印dp数组
    // 本题类似于爬楼梯问题
    public int rob(int[] nums) {
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