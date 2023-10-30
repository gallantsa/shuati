package 单调栈._4接雨水._42_接雨水;

import java.util.Stack;

public class Main {
}

class Solution {
    public int trap(int[] height) {
        int len = height.length;

        int res = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            // 如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                // 弹出 栈顶元素，并记录
                int cur = stack.pop();
                // 如果栈空了，那么就退出循环
                if (stack.isEmpty()) break;
                // 计算当前的雨水量
                // 雨水量 = (右边界 - 左边界 - 1) * 高度差
                int l = stack.peek();
                int r = i;
                int h = Math.min(height[l], height[r]) - height[cur];
                res += (r - l - 1) * h;
            }
            stack.push(i);
        }
        return res;
    }
}