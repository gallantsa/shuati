package 动态规划._14最后一块石头的重量II._1049_最后一块石头的重量II;

public class Main {
}

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        // 本质是尽量找到一个子集, 使得这个子集的和尽量接近target
        // 遍历物品
        for (int i = 0; i < stones.length; i++) {
            // 遍历背包
            for (int j = target; j >= stones[i]; j--) {
                // 当第i件物品的重量小于背包的容量时, 放入背包
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}