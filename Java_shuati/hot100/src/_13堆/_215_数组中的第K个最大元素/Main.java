package _13堆._215_数组中的第K个最大元素;

import java.util.PriorityQueue;

public class Main {
}

class Solution {
    public int findKthLargest(int[] nums, int k) {

        // 小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 遍历数组, 将元素加入小顶堆
        for (int num : nums) {
            queue.offer(num);
            // 如果堆中元素个数大于k, 则将堆顶元素出队
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}

class Solution2 {
    public int findKthLargest(int[] nums, int k) {

        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        // 遍历数组, 将元素加入大顶堆
        for (int num : nums) {
            queue.offer(num);
        }

        // 将堆顶元素出队k-1次
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        return queue.peek();
    }
}