package _16多维动态规划._72_编辑距离;

public class Main {
}

class Solution {
    public int minDistance(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int len1 = ch1.length, len2 = ch2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化
        // 第一行
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        // 第一列
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        // 从第二行第二列开始
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2 ; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    // 如果两个数相等, 则dp[i][j] = dp[i-1][j-1]
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果两个数不相等, 则dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}