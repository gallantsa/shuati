package 动态规划._42最长连续递增序列._674_最长连续递增序列;

import java.util.Arrays;

public class Main {
}

class Solution {
    // 与上一题相比
    // 本题的侧重点在于连续二字
    // 因此只需要两个相邻的数进行比较
    // dp数组的初始化为1, 是因为本题最小长度是1
    // dp数组的含义, 以i为结尾的最长递增子序列长度为dp[i]
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        // 初始化
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        // 记录最长连续递增序列
        int res = 1;
        for (int i = 0; i < len - 1; i++) {
            // 如果后一个数大于前一个数, 后一个数的dp[i+1] + 1
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }
}