package 动态规划._13分割等和子集._416_分割等和子集;

public class Main {
}

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果数组的和为奇数, 则不可能分割成两个和相等的子集
        if (sum % 2 !=0) return false;
        int target = sum / 2;

        // 本质是求nums中是否存在一个子集, 使得这个子集的和为target
        int[] dp = new int[target + 1];
        // 遍历物品
        for (int i = 0; i < nums.length; i++) {
            // 遍历背包
            for (int j = target; j >= nums[i]; j--) {
                // 当第i件物品的重量大于背包的容量时, 不放入背包
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            // 剪枝
            if (dp[target] == target) return true;
        }

        // return false;
        return dp[target] == target;
    }
}