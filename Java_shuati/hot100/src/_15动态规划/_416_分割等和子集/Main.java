package _15动态规划._416_分割等和子集;

public class Main {
}

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        // 计算数组元素和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // 如果数组元素和为奇数, 则不可能分割成两个和相等的子集
        if (sum % 2 != 0) {
            return false;
        }

        // 定义: dp[i][j]表示从数组的[0, i]范围内选取若干个正整数(可以是0个), 是否存在一种选取方案使得被选取的正整数的和等于j
        int n = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // 初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // 如果背包容量j大于等于nums[i - 1], 则可以选择装入或者不装入背包
                if (j - nums[i - 1] >= 0) {
                    // 装入或者不装入背包
                    // 装入背包: dp[i - 1][j - nums[i - 1]]
                    // 不装入背包: dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    // 如果背包容量j小于nums[i - 1], 则不能装入第i个物品
                } else { // j - nums[i - 1] < 0
                    // 背包容量不足, 不能装入第i个物品
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}

class Solution2 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 !=0) return false;
        int target = sum / 2;

        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }

            if (dp[target] == target) return true;
        }

        return false;
    }
}