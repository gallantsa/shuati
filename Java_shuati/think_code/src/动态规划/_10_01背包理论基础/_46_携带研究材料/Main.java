package 动态规划._10_01背包理论基础._46_携带研究材料;

import java.util.Scanner;

public class Main {

    private static int dp[][] = null;


    // 测试用例1:
    // 4 5
    // 1 2 3 4
    // 2 4 4 5
    // 期望结果: 8
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] weight = new int[m];
        int[] value = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            value[i] = sc.nextInt();
        }

        testWeightBagProblem(weight, value, n);

        System.out.println("===================== 最大价值如下: ====================");
        System.out.println(dp[m - 1][n]);
    }

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        dp = new int[value.length][bagSize + 1];

        // 初始化dp数组, 第一行和第一列, 其它地方什么值都可以
        // 当第一件物品的重量小于背包的容量时, 将第一件物品放入背包
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }

        // 这里的遍历顺序可以颠倒
        // 遍历物品
        for (int i = 1; i < value.length; i++) {
            // 遍历背包
            for (int j = 1; j <= bagSize; j++) {
                // 当第i件物品的重量大于背包的容量时, 不放入背包
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    // 当第i件物品的重量小于背包的容量时, 有两种选择, 放入背包或者不放入背包
                    // 不放入背包: dp[i][j] = dp[i - 1][j]
                    // 放入背包: dp[i][j] = dp[i - 1][j - weight[i]] + value[i]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        System.out.println("===================== dp数组如下: ====================");
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}
