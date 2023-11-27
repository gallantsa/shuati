package _15动态规划._139_单词拆分;

import java.util.Arrays;
import java.util.List;

public class Main {
}

class Solution {
    // 备忘录
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        // 备忘录, -1表示未计算, 0表示不能拆分, 1表示可以拆分
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        // 根据函数定义, 判断s[0..]是否能够拆分
        return dp(s, 0, wordDict);
    }

    // 定义: 返回s[start..]能否被wordDict拆分
    private boolean dp(String s, int start, List<String> wordDict) {
        // 如果整个字符串都被拼出来了, 说明可以拆分
        if (start == s.length()) {
            return true;
        }

        // 防止重复计算
        // 如果之前计算过, 直接返回结果
        if (memo[start] != -1) {
            return memo[start] == 1;
        }

        for (String word : wordDict) {
            int len = word.length();
            // 如果单词长度大于剩余字符串长度, 跳过
            if (len > s.length() - start) {
                continue;
            }

            String subStr = s.substring(start, start + len);
            // 如果单词不匹配, 跳过
            if (!subStr.equals(word)) {
                continue;
            }

            // 如果匹配, 递归判断剩余字符串
            if (dp(s, start + len, wordDict)) {
                memo[start] = 1;
                return true;
            }
        }
        // 如果所有单词都不匹配, 则返回false
        memo[start] = 0;
        return false;
    }
}