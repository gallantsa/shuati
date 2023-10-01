package 常用容器.用两个栈实现队列;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
}

class MyQueue {
    Stack<Integer> stk1, stk2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stk1 = new Stack<>();
        stk2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stk1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stk1.empty()) {
            stk2.push(stk1.pop());
        }
        int res = stk2.pop();
        while(!stk2.empty()) {
            stk1.push(stk2.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        while(!stk1.empty()) {
            stk2.push(stk1.pop());
        }
        int res = stk2.peek();
        while(!stk2.empty()) {
            stk1.push(stk2.pop());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stk1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */