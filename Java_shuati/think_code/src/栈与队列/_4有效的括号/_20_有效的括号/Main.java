package 栈与队列._4有效的括号._20_有效的括号;

import java.util.Arrays;
import java.util.Stack;

public class Main {
}

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')') {
                /*这段的判断顺序不能颠倒*/
                if (stack.isEmpty() || stack.pop() != '(' ) return false;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            } else if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
