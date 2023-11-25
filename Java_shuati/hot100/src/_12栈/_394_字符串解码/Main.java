package _12栈._394_字符串解码;

import java.util.Stack;

public class Main {
}

class Solution {
    // 解题思路: 用两个栈, 一个栈存放数字, 一个栈存放字符串
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();

        int multi = 0;
        // 记录'['之前的数字
        Stack<Integer> stack_multi = new Stack<>();
        // 记录'['之前的字符串
        Stack<String> stack_res = new Stack<>();

        // 遍历字符串
        for (char c : s.toCharArray()) {
            // 如果是'[', 则将数字和字符串分别入栈, 然后重置数字和字符串
            if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
                // 如果是']', 则取出数字和字符串
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp);
                // 如果是数字, 则更新multi
            } else if (c >= '0' && c <= '9') {
                // 这里multi要乘10, 因为数字可能是多位数, 如100
                multi = multi * 10 + Integer.parseInt(c + "");
                // 如果是字母, 则直接加入res
            } else {
                res.append(c);
            }
        }

        // 返回结果
        return res.toString();
    }
}