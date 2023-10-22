package 动态规划._7不同路径II._63_不同路径II;

public class Main {
}

class Solution {
    // 动态规划五部曲
    // 1. 确定dp[i]的含义: 到达第i行第j列的路径数量
    // 2. 确定递推公式: dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
    // 3. dp数组如何初始化: 第一行和第一列都为1
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 打印dp数组: 不需要打印
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 初始化第一行和第一列
        // 如果当前位置有障碍物, 则后面的位置都无法到达
        for (int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        // 如果当前位置有障碍物, 则后面的位置都无法到达
        for (int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                // 如果当前位置有障碍物, 则当前位置的路径数量为0
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i][j - 1] + dp[i - 1][j]);
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}