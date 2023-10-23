package 动态规划._9不同的二叉搜索树._96_不同的二叉搜索树;

public class Main {
}

class Solution {
    // 动态规划五部曲
    // 1. 确定dp[i]的含义: 以i为根节点的二叉搜索树有dp[i]个
    // 2. 确定递推公式: dp[i] = dp[j - 1] * dp[i - j]
    // 3. dp数组如何初始化: dp[0] = 1, dp[1] = 1
    // 4. 确定遍历顺序: 从前往后遍历
    // 5. 打印dp数组: 不需要打印
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j]; // dp[j - 1] * dp[i - j]表示以j为根节点的二叉搜索树的个数
            }
        }
        return dp[n];
    }
}