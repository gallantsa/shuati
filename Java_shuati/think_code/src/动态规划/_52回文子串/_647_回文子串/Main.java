package 动态规划._52回文子串._647_回文子串;

import java.util.Arrays;

public class Main {
}

class Solution {
    // 动规五部曲
    // 1. 确定dp数组以及下标的含义: dp[i][j]的含义是以s[i]和s[j]为边界的子串是否为回文子串
    // 2. 确定递推公式: 如果s[i] == s[j], 则dp[i][j] = dp[i+1][j-1]
    //                如果s[i] != s[j], 则dp[i][j] = false
    // 3. dp数组如何初始化: 对角线为true, 其余为false
    // 4. 确定遍历顺序: 从下往上, 从左往右
    // 5. 举例推导dp数组
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        // 初始化
        // Java中boolean数组默认值为false
        boolean[][] dp = new boolean[len][len];

        // 记录回文子串个数
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // 如果两个数相等
                if (ch[i] == ch[j]) {
                    // 如果两个数相邻, 则dp[i][j] = true
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res++;
                        // 如果两个数不相邻, 则dp[i][j] = dp[i+1][j-1]
                    } else if (dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}