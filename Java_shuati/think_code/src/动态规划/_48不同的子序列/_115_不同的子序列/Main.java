package 动态规划._48不同的子序列._115_不同的子序列;

public class Main {
}

class Solution {
    // 动规五部曲
    // 1. 确定dp数组以及下标的含义: dp[i][j]的含义是以s[i - 1]中以t[j - 1]结尾的子序列个数
    // 2. 确定递推公式: 如果s[i - 1] == t[j - 1], 则dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
    //                如果s[i - 1] != t[j - 1], 则dp[i][j] = dp[i-1][j]
    // 3. dp数组如何初始化: 第一行为0, 第一列为1
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 举例推导dp数组
    public int numDistinct(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        int len1 = ch1.length, len2 = ch2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化
        // 第一行
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = 0;
        }
        // 第一列
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 如果两个数不相等, 则dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len1][len2];
    }
}