package 动态规划._24完全平方数._279_完全平方数;

import java.util.Arrays;

public class Main {
}

// 和上一题几乎一样
class Solution {
    // 版本一: 先遍历物品, 再遍历背包
    public int numSquares(int n) {
        // 初始化
        int[] dp = new int[n + 1]; // 创建一个长度为 n + 1 的数组 dp
        Arrays.fill(dp, Integer.MAX_VALUE); // 将 dp 数组中的所有元素初始化为最大值
        dp[0] = 0;

        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
    
    // 版本二: 先遍历背包, 再遍历物品
    public int numSquares2(int n) {
        // 初始化
        int[] dp = new int[n + 1]; // 创建一个长度为 n + 1 的数组 dp
        Arrays.fill(dp, Integer.MAX_VALUE); // 将 dp 数组中的所有元素初始化为最大值
        dp[0] = 0;

        // 遍历背包
        for (int i = 1; i <= n; i++) {
            // 遍历物品
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        
        return dp[n];
    }
}