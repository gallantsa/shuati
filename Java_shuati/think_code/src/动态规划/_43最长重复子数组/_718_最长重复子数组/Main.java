package 动态规划._43最长重复子数组._718_最长重复子数组;

import java.util.Arrays;

public class Main {

}

class Solution {
    //
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;

        // dp[i][j]的含义是以nums1[i - 1]和nums2[j - 1]结尾的最长重复子数组长度
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化
        // 第一行
        Arrays.fill(dp[0], 0);
        // 第一列
        for (int i = 0; i < len1; i++) {
            dp[i][0] = 0;
        }

        // 记录最长重复子数组长度
        int res = 0;
        // 从第二行第二列开始
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                // 如果两个数相等, 则dp[i][j] = dp[i-1][j-1] + 1
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // 更新最长重复子数组长度
                    // 这种写法方便找到最大值
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
