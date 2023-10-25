package 动态规划._19零钱兑换II._518_零钱兑换II;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(solution.change(amount, coins));
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;
        // 虽然这题是完全背包问题, 但是遍历物品和遍历背包的顺序不能颠倒
        // 先遍历物品, 再遍历背包, 求出的是组合数
        // 先遍历背包, 再遍历物品, 求出的是排列数
        // 本题求的是组合数, 所以先遍历物品, 再遍历背包
        // 遍历物品
        for (int i = 0; i < coins.length; i++) {
            // 遍历背包
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]]; // dp[j]表示组成金额j的组合数
            }
        }
        return dp[amount];
    }
}