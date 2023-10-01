package 数组.二分查找._35搜索插入位置;

public class Main {
}

class Solution {
    public int searchInsert1(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        // target 小于 所有元素
        if (target < nums[0]) return l;

        // target 大于 所有元素
        if (target > nums.length - 1) return r + 1;

        // target 等于 某个元素
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        // target 插入数组中的位置
        return r + 1;
    }

    // 简化版
    public int searchInsert2(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        // target 插入数组中的位置
        return r + 1;
    }
}
