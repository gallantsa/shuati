package 动态规划._8整数拆分._343_整数拆分;

public class Main {
}

class Solution {
    // 动态规划五部曲
    // 1. 确定dp[i]的含义: 将i拆分成至少两个正整数的和, 使得这些整数的乘积最大, 返回这个乘积
    // 2. 确定递推公式: dp[i] = max(j * (i - j), j * dp[i - j])
    // 3. dp数组如何初始化: dp[0] = 0, dp[1] = 0, dp[2] = 1
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 打印dp数组: 不需要打印
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}