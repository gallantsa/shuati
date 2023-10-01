package 栈与队列._7滑动窗口最大值._239_滑动窗口最大值;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
}

//自定义队列
class MyQueue {
    Deque<Integer> deque = new LinkedList();

    /*弹出对头*/
    void poll(int val) {
        if(!deque.isEmpty() && deque.peek() == val) deque.poll();
    }

    /*加入队列*/
    void add(int val) {
        while(!deque.isEmpty() && deque.getLast() < val) deque.removeLast();
        deque.add(val);
    }

    /*获得最大值*/
    int peek() {
        return deque.peek();
    }

}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*如果数组长度等于1, 直接返回数组*/
        if (nums.length == 1) return nums;

        /*定义存放结果的数组*/
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;

        /*自定义队列*/
        MyQueue myQueue = new MyQueue();

        /*先将前k个元素加入队列*/
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        /*获得前k个元素中的最大值*/
        res[num++] = myQueue.peek();

        for (int i = k; i < nums.length; i++) {
            /*移动窗口*/
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            /*获取最大值*/
            res[num++] = myQueue.peek();
        }

        return res;
    }
}
