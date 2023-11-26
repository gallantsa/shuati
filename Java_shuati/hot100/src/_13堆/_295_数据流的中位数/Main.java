package _13堆._295_数据流的中位数;

import java.util.PriorityQueue;

public class Main {
}

class MedianFinder {

    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;

    public MedianFinder() {
        // 默认小顶堆
        small = new PriorityQueue<>();
        large = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        // 如果小根堆的元素个数大于等于大根堆的元素个数, 则将元素加入大根堆
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
            // 否则将元素加入小根堆
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        // 如果两个堆的元素数量不同, 多的那个堆的堆顶元素就是中位数
        if (small.size() > large.size()) {
            return small.peek();
        } else if (small.size() < large.size()) {
            return large.peek();
        }
        // 如果两个堆的元素数量相同, 则两个堆的堆顶元素的平均值就是中位数
        return (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */