package 动态规划._53最长回文子序列._516_最长回文子序列;

public class Main {
}

class Solution {
    // 动规五部曲
    // 1. 确定dp数组以及下标的含义: dp[i][j]的含义是以s[i]和s[j]结尾的最长回文子序列长度
    // 2. 确定递推公式: 如果s[i] == s[j], 则dp[i][j] = dp[i+1][j-1] + 2
    //                如果s[i] != s[j], 则dp[i][j] = max(dp[i+1][j], dp[i][j-1])
    // 3. dp数组如何初始化: dp[i][i] = 1
    // 4. 确定遍历顺序: 从下往上, 从左往右
    // 5. 举例推导dp数组
    public int longestPalindromeSubseq(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;

        int[][] dp = new int[len][len];

        // 初始化dp数组
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }

        // 遍历顺序
        // 从下往上, 从左往右
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len ; j++) {
                if (ch[i] == ch[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}