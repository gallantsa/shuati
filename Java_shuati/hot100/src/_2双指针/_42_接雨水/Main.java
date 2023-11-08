package _2双指针._42_接雨水;

public class Main {
}

class Solution {
    // 双指针
    // 解题思路: 记录每个位置左边的最大值和右边的最大值, 然后计算每个位置能接的雨水量
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;

        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        // 计算maxLeft
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        // 计算maxRight
        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        // 计算结果
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return res;
    }
}
