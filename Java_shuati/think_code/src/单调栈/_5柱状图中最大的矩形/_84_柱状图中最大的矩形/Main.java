package 单调栈._5柱状图中最大的矩形._84_柱状图中最大的矩形;

import java.util.Stack;

public class Main {
}

class Solution {
    // 单调递减栈
    // 求下一个更小元素
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        // 收尾加 0, 为了让栈中的元素都能弹出, 从而计算面积
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        newHeights[len + 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        heights = newHeights;
        len = heights.length;

        Stack<Integer> stack = new Stack<>();

        int res = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int cur = stack.pop(); // 当前的高度
                int l = stack.peek(); // 左边第一个小于当前高度的下标
                int r = i; // 右边第一个小于当前高度的下标
                // 计算当前的面积, 并更新最大面积
                res = Math.max(res, (r - l - 1) * heights[cur]); // (r - l - 1) 表示的是宽度
            }
            stack.push(i);
        }
        return res;
    }
}