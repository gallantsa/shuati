package 贪心算法._4最大子序和._53_最大子序和;

public class Main {
}

class Solution {
    // 贪心算法
    // 局部最优解: 当前和大于0, 则继续累加
    // 全局最优解: 当前和大于最大值, 则更新最大值
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // 如果当前和小于0, 则重新开始计算
            if (sum < 0) {
                sum = nums[i];
            } else {
                // 如果当前和大于0, 则继续累加
                sum += nums[i];
            }
            // 更新最大值
            result = Math.max(result, sum);
        }
        return result;
    }
}