package _11二分查找._34_在排序数组中查找元素的第一个和最后一个位置;

public class Main {
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
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
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 搜索区间变为[mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left, mid - 1]
                right = mid - 1;
            }
        }

        // 检查left越界情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length -  1;

        // 搜索区间为[left, right]
        while (left <= right) {
            // 防止溢出
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                // 收缩左边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                // 搜索区间变为[mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left, mid - 1]
                right = mid - 1;
            }
        }

        // 检查right越界情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}