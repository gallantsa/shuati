package _4子串._239_滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
}

class Solution {
    // 单调队列
    // 计算区间最大值
    // RMQ
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        int[] res = new int[len - k + 1];
        int index = 0;
        // 双端队列
        // 用来存储当前窗口中的最大值的下标
        // 队列中的元素是单调递减的
        // 队首元素是当前窗口中的最大值
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            // 如果队列中的元素个数超过了k个，就删除队首元素
            // 这里是怎么说明元素个数超过了k个的?
            // 因为队列中存储的是当前窗口中的最大值的下标，而下标之差就是元素个数
            // 如果队首元素的下标小于等于i-k，说明队首元素已经不在当前窗口中了，就删除队首元素
            if (i >= k && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            // 如果当前元素比队尾元素大，就删除队尾元素
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            // 将当前元素加入队列
            deque.addLast(i);
            // 如果当前元素的下标大于等于k-1，说明当前窗口已经形成，可以记录当前窗口的最大值了
            // k - 1是什么意思?
            // 因为下标是从0开始的，所以当前元素的下标是i，那么当前窗口的最后一个元素的下标就是i-k+1
            if (i >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}