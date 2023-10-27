package 动态规划._41最长递增子序列._300_最长递增子序列;

import java.util.Arrays;

public class Main {
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;

        // 初始化
        int[] dp = new int[len];
        // 最小长度为1
        Arrays.fill(dp, 1);

        // 比较nums[i]与nums[i]之前的元素
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 如果nums[i] > nums[j], 则dp[i] = dp[j] + 1
                if (nums[i] > nums [j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // stream流的使用
        return Arrays.stream(dp).max().getAsInt();
    }
}
