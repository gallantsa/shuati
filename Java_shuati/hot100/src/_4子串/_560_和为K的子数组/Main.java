package _4子串._560_和为K的子数组;

import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    // 前缀和 + 哈希表优化
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        // key: 前缀和, value: 前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化
        // 前缀和为0的子数组出现了1次
        map.put(0, 1);
        // 遍历数组
        for (int num : nums) {
            // 计算前缀和
            // sum是当前元素的前缀和
            sum += num;
            // 如果map中存在前缀和为sum - k，那么就找到了以当前元素结尾的子数组
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            // 更新map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    // 前缀和
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        // 前缀和数组
        int[] preSum = new int[len + 1];
        // 初始化
        preSum[0] = 0;

        // 构造前缀和数组
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int res = 0;
        // 枚举所有子数组
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                // 如果当前子数组的和等于k, 那么结果加1
                if (preSum[j + 1] - preSum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}