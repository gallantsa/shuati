package 动态规划._18完全背包理论基础._52_携带研究材料;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();

        int[] wi = new int[n];
        int[] vi = new int[n];
        for (int i = 0; i < n; i++) {
            wi[i] = sc.nextInt();
            vi[i] = sc.nextInt();
        }

        System.out.println(testWeightBagProblem2(wi, vi, v));
    }

    // 先遍历物品, 再遍历背包
    private static int testWeightBagProblem(int[] wi, int[] vi, int v) {
        // dp的长度为背包容量+1
        int[] dp = new int[v + 1];
        // 这里的遍历顺序可以颠倒, 因为这是纯完全背包问题, 每个物品可以无限次放入背包
        // 遍历物品
        for (int i = 0; i < wi.length; i++) {
            // 遍历背包
            // 这里是正序遍历, 因为dp[j - wi[i]]是上一行的数据, 如果倒序遍历, 会被覆盖
            for (int j = wi[i]; j <= v; j++) {
                dp[j] = Math.max(dp[j], dp[j - wi[i]] + vi[i]);
            }
        }
        return dp[v];
    }

    // 先遍历背包, 再遍历物品
    private static int testWeightBagProblem2(int[] wi, int[] vi, int v) {
        // dp的长度为背包容量+1
        int[] dp = new int[v + 1];
        // 这里的遍历顺序可以颠倒
        // 遍历背包
        // 这里j从1, 从0开始都行, 因为j为背包容量, 背包容量为0时, 价值也为0
        for (int j = 0; j <= v; j++) {
            // 遍历物品
            for (int i = 0; i < wi.length; i++) {
                // 当第i件物品的重量小于背包的容量时, 放入背包
                if (j >= wi[i]) {
                    dp[j] = Math.max(dp[j], dp[j - wi[i]] + vi[i]);
                }
            }
        }

        return dp[v];
    }
}
