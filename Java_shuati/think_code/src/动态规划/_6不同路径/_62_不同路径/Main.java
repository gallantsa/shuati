package 动态规划._6不同路径._62_不同路径;

public class Main {
}

class Solution {
    // 动态规划五部曲
    // 1. 确定dp[i]的含义: 到达第i行第j列的路径数量
    // 2. 确定递推公式: dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
    // 3. dp数组如何初始化: 第一行和第一列都为1
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 打印dp数组: 不需要打印
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化第一行和第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}