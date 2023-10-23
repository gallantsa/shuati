package 动态规划._11_01背包理论基础2._46_携带研究材料;

import java.util.Scanner;

public class Main {

    private static int dp[] = null;


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
    }

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        // 初始化 dp[0] = 0;
        dp = new int[bagSize + 1];

        // 遍历物品, 不可颠倒
        for (int i = 0; i < weight.length; i++) {
            // 这里需要倒序遍历, 因为dp[j - weight[i]]是上一行的数据, 如果正序遍历, 会被覆盖
            // 遍历背包
            for (int j = bagSize; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        // 打印dp数组
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + "\t");
        }
        System.out.println();

        System.out.println(dp[bagSize]);
    }
}
