package _5普通数组._238_除自身以外数组的乘积;

public class Main {
}

class Solution {
    // 自行模拟
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        // 计算左边的乘积
        int left = 1;
        for (int i = 0; i < len; i++) {
            res[i] = left;
            left *= nums[i];
        }

        // 计算右边的乘积
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }
}