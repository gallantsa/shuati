package 单调栈._1每日温度._739_每日温度;

import java.util.Stack;

public class Main {
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;

        // 加入栈的是下标
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[len];

        stack.push(0);

        /**
         如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         所以弹出 栈顶元素，并记录
         如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         否则的话，可以直接入栈。
         注意，单调栈里 加入的元素是 下标。
         */
        for (int i = 1; i < len; i++) {
            // 如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                // 如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    // 弹出 栈顶元素，并记录
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                // 否则的话，可以直接入栈。
                stack.push(i);
            }
        }
        return res;
    }
}