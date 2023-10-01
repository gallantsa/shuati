package 栈与队列._5删除字符串中的所有相邻重复项._1047_删除字符串中的所有相邻重复项;

import java.util.Stack;

public class Main {
}

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) stack.push(ch);
            else if (stack.peek() != ch) stack.push(ch);
            else stack.pop();
        }
        StringBuffer sb = new StringBuffer();
        stack.stream()
                /*forEach在不影响原来的集合的前提下, 对集合中的每个元素进行操作, 同时是终结方法*/
                /*map是中间操作, 对集合中的每个元素进行操作同时会影响原来的集合产生新的流*/
                .forEach(sb::append);
        return sb.toString();

    }
}