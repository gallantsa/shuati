package _15动态规划._70_爬楼梯;


public class Main {
}

class Solution {

    public int climbStairs(int n) {
        int[] v = new int[2];
        v[0] = 1;
        v[1] = 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < v.length; j++) {
                if (i >= v[j]) {
                    dp[i] += dp[i - v[j]];
                }
            }
        }
        return dp[n];
    }
}