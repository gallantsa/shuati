package 哈希表._6四数相加II._454四数相加II;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num1: nums1) {
            for (int num2: nums2) {
                int count = map.getOrDefault(num1 + num2, 0);
                count ++;
                map.put(num1 + num2, count);
            }
        }

        for (int num1: nums3) {
            for (int num2: nums4) {
                if (map.containsKey(0 - (num1 + num2))) {
                    res += map.get(0 - (num1 + num2));
                }
            }
        }
        return res;
    }
}