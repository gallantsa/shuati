package _1哈希._128_最长连续序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        // 将数组中的元素放入哈希表中
        for (int num : nums) {
            hash.add(num);
        }

        int max = 0;
        // 遍历数组中的元素
        for (int num : nums) {
            // 如果当前元素的前一个元素不在哈希表中，说明当前元素是一个连续序列的起点, 这里很妙
            if (!hash.contains(num - 1)) {
                // 从当前元素开始，向后遍历，直到遇到不连续的元素
                int cur = num;
                int curMax = 1;
                while (hash.contains(cur + 1)) {
                    cur++;
                    curMax++;
                }
                // 更新最大值
                max = Math.max(max, curMax);
            }
        }
        return max;
    }
}
