package 数组.二分查找._704二分查找;

// https://leetcode.cn/problems/binary-search/submissions/
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 2, 3, 4, 5};
        System.out.println(solution.search1(ints, 3));
    }
}


class Solution {
    // 方法一: [left, right]型
    public int search1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) { // 这里要加=, 因为left = right有意义 表示数组为空
            int mid = l + r >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 方法二: [left, right)型
    public int search2(int[] nums, int target) {
        int l = 0, r = nums.length; // 注意这里r的值
        while (l < r) { // 这里不用加=, 因为l == r 无意义
            int mid = l + r >> 1;
            if (nums[mid] > target) {
                r = mid; // 这里要赋值为 mid 因为要保证[left, right)
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}


