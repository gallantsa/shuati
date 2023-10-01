package 栈与队列._8前k个高频元素._347_前k个高频元素;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*先用map统计每个元素出现次数*/
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /*定义优先级队列, 采用小顶堆*/
        /*int[] 的第一个元素为key, 第二个元素为value*/
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] res = new int[k];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] tmp = new int[2];
            tmp[0] = entry.getKey();
            tmp[1] = entry.getValue();
            /*加入优先级队列*/
            queue.offer(tmp);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        for(int i = 0; i < k; i ++) {
            res[i] = queue.poll()[0]; // 获取优先队列里的元素
        }
        return res;
    }
}
