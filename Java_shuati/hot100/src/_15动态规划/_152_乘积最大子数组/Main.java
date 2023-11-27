package _15动态规划._152_乘积最大子数组;

public class Main {
}

class Solution {
    // 本题为什么有两个状态?
    // 因为乘法有负负得正的特性, 所以需要记录最小值
    public int maxProduct(int[] nums) {
        // 定义: dpMax[i]表示以nums[i]结尾的乘积最大子数组的乘积
        int[] dpMax = new int[nums.length];
        // 定义: dpMin[i]表示以nums[i]结尾的乘积最小子数组的乘积
        int[] dpMin = new int[nums.length];

        // 初始化
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        // 遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 状态转移方程
            // dpMax[i]表示以nums[i]结尾的乘积最大子数组的乘积
            // dpMin[i]表示以nums[i]结尾的乘积最小子数组的乘积
            // dpMax[i] = max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i], nums[i])
            // dpMin[i] = min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i], nums[i])
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
        }

        // 遍历dpMax数组, 找出最大值
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dpMax.length; i++) {
            res = Math.max(res, dpMax[i]);
        }

        return res;
    }
}