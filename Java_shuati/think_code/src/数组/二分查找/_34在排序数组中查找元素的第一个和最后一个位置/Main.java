package 数组.二分查找._34在排序数组中查找元素的第一个和最后一个位置;

public class Main {

}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 求出的边界为左开右开
        int lb = getLeft(nums, target);
        int rb = getRight(nums, target);

        // 情况一
        if (lb == -2 || rb == -2) return new int[]{-1, -1};
        // 情况二
        if (rb - lb > 1) return new int[]{lb + 1, rb - 1};
        // 情况二
        return new int[]{-1, -1};
    }

    public int getRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int rb = -2;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] <= target) {
                l = mid + 1;
                rb = l;
            } else {
                r = mid - 1;
            }
        }
        return rb;
    }

    public int getLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int lb = -2;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) { // 主要关注 num[mid] == target的情况
                r = mid - 1;
                lb = r;
            } else {
                l = mid + 1;
            }
        }
        return lb;
    }
}
