package _15动态规划._198_打家劫舍;

import java.util.Arrays;

public class Main {
}

class Solution {

    private int[] memo;

    public int rob(int[] nums) {

        // 1. 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        // 强盗从第0间房子开始抢劫
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        // 避免重复计算
        if (memo[start] != -1) {
            return memo[start];
        }

        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        // 记入备忘录
        memo[start] = res;
        return res;
    }
}


class Solution2 {
    // 动态规划
    // dp[i]表示前i间房子能偷窃到的最高金额
    // dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}