package 动态规划._49两个字符串的删除操作._583_两个字符串的删除操作;

public class Main {
}

class Solution {
    // 和最长公共子序列一模一样
    public int minDistance(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();

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
        return len1 + len2 - 2 * res;
    }
}