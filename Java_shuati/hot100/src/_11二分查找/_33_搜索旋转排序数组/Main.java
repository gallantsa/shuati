package _11二分查找._33_搜索旋转排序数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
}


// 解题思路: 先利用hashmap记录每个元素的索引, 然后对数组排序, 最后二分查找
// 时间复杂度: O(nlogn)
// 时间复杂度没有达到题目要求
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int search(int[] nums, int target) {
        int i = 0;
        for (int num : nums) {
            map.put(num, i++);
        }

        Arrays.sort(nums);
        return left_bound(nums, target);
    }

    private int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length -  1;

        // 搜索区间为[left, right]
        while (left <= right) {
            // 防止溢出
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                // 收缩右边界
                return map.get(nums[mid]);
            } else if (nums[mid] < target) {
                // 搜索区间变为[mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left, mid - 1]
                right = mid - 1;
            }
        }

        return -1;
    }
}