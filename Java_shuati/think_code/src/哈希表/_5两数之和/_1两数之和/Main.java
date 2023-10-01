package 哈希表._5两数之和._1两数之和;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ints = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            ints[0] = i;
            if (map.containsKey(tar)) {
                ints[1] = map.get(tar);
                return ints;
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
