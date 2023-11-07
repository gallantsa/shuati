package _1哈希._1两数之和;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        // 不能一开始就把所有的元素放入map中, 因为可能会出现[3, 3] 6这种情况
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
                break;
            }
            // 如果没有找到, 再将当前元素放入map中, 等待后续的元素来找, 这样就避免了使用同一个元素两次的情况
            map.put(nums[i], i);
        }
        return res;
    }
}