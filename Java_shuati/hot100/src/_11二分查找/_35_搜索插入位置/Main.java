package _11二分查找._35_搜索插入位置;

public class Main {
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        return left_bound(nums, target);
    }

    private int left_bound(int[] nums, int target) {
        // 搜索区间为[left, right)
        int left = 0;
        int right = nums.length; // 注意

        // 这里left < right而不是left <= right
        // 因为我们的搜索区间是[left, right), 左闭右开
        // 所以当left == right时, 搜索区间[left, right)是空的, 所以循环结束
        while (left < right) { // 注意
            // 防止溢出
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                // 收缩右边界
                right = mid;
            } else if (nums[mid] < target) {
                // 搜索区间变为[mid + 1, right)
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为[left, mid)
                right = mid; // 注意
            }
        }

        return left;
    }
}