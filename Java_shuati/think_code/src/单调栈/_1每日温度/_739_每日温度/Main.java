package 单调栈._1每日温度._739_每日温度;

import java.util.Stack;

public class Main {
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;

        Stack<Integer> stack = new Stack<>();

        int[] res = new int[len];

        stack.push(0);

        for (int i = 1; i < len; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}