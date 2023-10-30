package 单调栈._3下一个更大元素II._503_下一个更大元素II;

import java.util.Arrays;
import java.util.Stack;

public class Main {
}

class Solution {
    // 与上一题的区别在于，这里的数组是成环的，所以需要遍历两次
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];
        Arrays.fill(res, -1);

        // stack 存放的依然是下标
        Stack<Integer> stack = new Stack<>();
        // 这里没有提前push，而是在遍历的时候再push, 因此和上一题代码模版有点区别, 但是思想是一样的
        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % len];
                stack.pop();
            }
            stack.push(i % len);
        }
        return res;
    }
}