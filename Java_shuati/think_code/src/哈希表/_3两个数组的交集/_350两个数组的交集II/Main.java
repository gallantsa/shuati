package 哈希表._3两个数组的交集._350两个数组的交集II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1); // 如果nums1的长度大于nums2的长度, 交换数组元素
        }

        Map<Integer, Integer> map = new HashMap<>();
        // 数组每个数出现次数
        for (int num: nums1) {
            int count = map.getOrDefault(num, 0) + 1; // 获取key的value如果value不存在, 则生成一个(value, 0)的键值对
            map.put(num, count);
        }

        int[] res = new int[nums1.length];
        int index = 0;
        for (int num: nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
               res[index++] = num;
               count--;
               if (count > 0) {
                   map.put(num, count);
               } else {
                   map.remove(num);
               }
            }
        }
        // 获取res数组中前index元素组成的数组
        return Arrays.copyOfRange(res, 0, index);

    }
}
