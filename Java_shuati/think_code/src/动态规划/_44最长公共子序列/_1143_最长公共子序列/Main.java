package 动态规划._44最长公共子序列._1143_最长公共子序列;


public class Main {
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();

        int len1 = ch1.length, len2 = ch2.length;

        // 初始化
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 记录最长公共子序列长度
        int res = 0;
        // 从第二行第二列开始
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    // 如果两个数相等, 则dp[i][j] = dp[i-1][j-1] + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果两个数不相等, 则dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                // 更新最长公共子序列长度
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}