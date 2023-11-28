package _16多维动态规划._64_最小路径和;

public class Main {
}

class Solution {
    public int minPathSum(int[][] grid) {
        // 定义: dp[i][j]表示从左上角到(i, j)的最小路径和
        int[][] dp = new int[grid.length][grid[0].length];

        // 初始化
        dp[0][0] = grid[0][0];

        // 初始化第一行
        for (int i = 1; i < grid[0].length; i++) {
            // 状态转移方程
            // dp[i][j]表示从左上角到(i, j)的最小路径和
            // dp[i][j] = dp[i][j - 1] + grid[i][j]
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 初始化第一列
        for (int i = 1; i < grid.length; i++) {
            // 状态转移方程
            // dp[i][j]表示从左上角到(i, j)的最小路径和
            // dp[i][j] = dp[i - 1][j] + grid[i][j]
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 遍历数组
        for (int i = 1; i < grid.length; i++) {
            // 遍历数组
            for (int j = 1; j < grid[0].length; j++) {
                // 状态转移方程
                // dp[i][j]表示从左上角到(i, j)的最小路径和
                // dp[i][j] = min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j]
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

        // 返回结果
        return dp[grid.length - 1][grid[0].length - 1];
    }
}