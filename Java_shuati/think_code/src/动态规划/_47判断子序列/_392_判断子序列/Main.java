package 动态规划._47判断子序列._392_判断子序列;

public class Main {
}

class Solution {

    // 这一题和最长公共子序列几乎一模一样
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        if (t.equals("")) {
            return false;
        }
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        if (len1 > len2) {
            return false;
        }

        // 初始化dp数组
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
        return res == len1;
    }
}