package 栈与队列._6逆波兰表达式求值._150_逆波兰表达式求值;

import java.util.Stack;

public class Main {
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+")) {
                String s1 = stack.pop();
                String s2 = stack.pop();
                int res = Integer.parseInt(s2) + Integer.parseInt(s1);
                stack.push(String.valueOf(res));
            } else if (token.equals("-")) {
                String s1 = stack.pop();
                String s2 = stack.pop();
                int res = Integer.parseInt(s2) - Integer.parseInt(s1);
                stack.push(String.valueOf(res));
            } else if (token.equals("*")) {
                String s1 = stack.pop();
                String s2 = stack.pop();
                int res = Integer.parseInt(s2) * Integer.parseInt(s1);
                stack.push(String.valueOf(res));
            } else if (token.equals("/")) {
                String s1 = stack.pop();
                String s2 = stack.pop();
                int res = Integer.parseInt(s2) / Integer.parseInt(s1);
                stack.push(String.valueOf(res));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
