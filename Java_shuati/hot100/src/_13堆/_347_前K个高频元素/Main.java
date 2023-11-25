package _13堆._347_前K个高频元素;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 先统计每个元素出现的频率
        // key: 元素, value: 频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        // 小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        // 遍历map, 将元素加入小顶堆
        for (Integer key : map.keySet()) {
            queue.offer(key);
            // 如果堆中元素个数大于k, 则将堆顶元素出队
            if (queue.size() > k) {
                queue.poll();
            }
        }

        // 将堆中元素放入数组
        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
        }

        return res;
    }
}