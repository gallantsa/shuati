package _2双指针._11_盛最多水的容器;

public class Main {
}

class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            // 计算当前容器的容量
            int cur = (right - left) * Math.min(height[left], height[right]);
            // 更新最大容量
            res = Math.max(res, cur);
            // 移动指针
            // 如果左边的柱子比右边的柱子矮，那么左边的柱子向右移动，否则右边的柱子向左移动
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}