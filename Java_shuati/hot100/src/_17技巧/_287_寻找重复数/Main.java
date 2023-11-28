package _17技巧._287_寻找重复数;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            if (hash.containsKey(num)) {
                return num;
            }
            hash.put(num, 1);
        }
        return -1;
    }
}