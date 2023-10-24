package 动态规划._17一和零._474_一和零;

public class Main {
}

class Solution {
    // 动态规划五部曲
    // 1. 确定dp[i][j]的含义: 使用i个0和j个1能够组成的字符串的最大数量
    // 2. 确定递推公式: dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)
    // 3. dp数组如何初始化: dp[0][0] = 0
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        // 遍历物品
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            // 统计str中0和1的个数
            for (char c : str.toCharArray()) {
                if (c == '0') zeroNum++;
                else oneNum++;
            }
            // 遍历背包
            // 这里的遍历顺序是从后往前遍历, 因为dp[i][j]依赖于dp[i - zeroNum][j - oneNum]
            // 这里的两个for循环可以颠倒
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}