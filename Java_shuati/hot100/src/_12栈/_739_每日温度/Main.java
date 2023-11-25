package _12栈._739_每日温度;

import java.util.Stack;

public class Main {
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();

        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            // 如果栈不为空, 且当前元素大于栈顶元素, 则栈顶元素出栈, 并更新res
            // 单调递增栈 - 找到右边第一个比当前元素大的元素
            // 栈中存放的是元素的下标
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            // 当前元素入栈
            stack.push(i);
        }

        return res;
    }
}