package 单调栈._2下一个更大元素I._496_下一个更大元素I;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Main {
}

class Solution {
    // 单调栈
    // 单调栈的作用: 存放的是遍历过的元素
    // 单调递增栈 - 所求的是下一个更大元素
    // 单调递减栈 - 所求的是下一个更小元素
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[len1];

        // 加入栈的是下标
        Stack<Integer> stack = new Stack<>();
        // 用于存放 nums1 中元素的下标
        HashMap<Integer, Integer> map = new HashMap<>();

        // 初始化 res 数组
        Arrays.fill(res, -1);

        // 将 nums1 中的元素的下标存入 map 中
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i], i);
        }

        stack.push(0);
        // 遍历 nums2
        for (int i = 1; i < len2; i++) {
            // 如果当前遍历的元素小于栈顶元素，直接入栈
            if (nums2[i] < nums2[stack.peek()])
                stack.push(i);
            // 如果当前遍历的元素等于栈顶元素，直接入栈
            else if (nums2[i] == nums2[stack.peek()]){
                stack.push(i);
                // 如果当前遍历的元素大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
            } else {
                // 如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    // 如果栈顶元素在 nums1 中存在，那么就将 res 中对应的位置赋值
                    if (map.containsKey(nums2[stack.peek()])) {
                        // 获取 nums1 中元素的下标
                        int index = map.get(nums2[stack.peek()]);
                        // 将 res 中对应的位置赋值
                        res[index] = nums2[i];
                    }
                    // 弹出 栈顶元素
                    stack.pop();
                }
                // 否则的话，可以直接入栈。
                stack.push(i);
            }
        }
        return res;
    }
}