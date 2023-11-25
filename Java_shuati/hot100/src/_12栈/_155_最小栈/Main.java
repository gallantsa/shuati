package _12栈._155_最小栈;

import java.util.Stack;

public class Main {
}

class MinStack {

    // 记录栈中所有元素
    Stack<Integer> stack1;

    // 记录栈中最小元素
    Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty() || val <= stack2.peek()) {
            stack2.push(val);
        }
    }

    public void pop() {
        // 注意: 这里不能用==, 因为Integer是对象, ==比较的是对象的地址
        if (stack1.pop().equals(stack2.peek())) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */