package _2023._11._29._2336_无限集中的最小数字;

import java.util.PriorityQueue;

public class Main {
}

class SmallestInfiniteSet {
    // 维护一个小根堆
    PriorityQueue<Integer> queue;

    public SmallestInfiniteSet() {
        // 初始化小根堆
        queue = new PriorityQueue<>();
        // 将所有正整数加入小根堆
        for (int i = 1; i <= 1000; i++) {
            queue.add(i);
        }
    }

    /**
     * 弹出最小的正整数
     * @return
     */
    public int popSmallest() {
        return queue.poll();
    }

    /**
     * 将一个正整数加入集合
     * @param num
     */
    public void addBack(int num) {
        // 如果集合中已经存在该元素，直接返回
        if (queue.contains(num)) {
            return;
        }
        queue.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */