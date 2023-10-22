package 动态规划._3爬楼梯._70_爬楼梯;

public class Main {
}

class Solution {
    // 动态规划五部曲
    // 1. 确定dp[i]的含义: 达到第i个台阶有dp[i]种方法
    // 2. 确定递推公式: dp[i] = dp[i - 1] + dp[i - 2]
    // 3. dp数组如何初始化: dp[1] = 1, dp[2] = 2
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 打印dp数组: 不需要打印
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}