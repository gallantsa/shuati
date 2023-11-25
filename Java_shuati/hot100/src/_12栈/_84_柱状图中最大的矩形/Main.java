package _12栈._84_柱状图中最大的矩形;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n]; // left[i]表示第i个柱子左边第一个比它小的柱子的下标
        int[] right = new int[n]; // right[i]表示第i个柱子右边第一个比它小的柱子的下标


        Arrays.fill(left, -1); // 初始化为-1, 表示左边没有比它小的柱子
        Arrays.fill(right, n); // 初始化为n, 表示右边没有比它小的柱子
        Deque<Integer> stack = new ArrayDeque<>();

        // 单调递增栈 - 找到左边第一个比当前元素小的元素
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();

        // 单调递增栈 - 找到右边第一个比当前元素小的元素
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }

        return res;
    }
}
