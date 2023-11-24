package _11二分查找._4_寻找两个正序数组的中位数;

import java.util.Arrays;

public class Main {
}

// 解题思路: 先合并两个数组, 然后排序, 最后求中位数
// 时间复杂度: O((m+n)log(m+n))
// 题目虽然解出来了, 但是时间复杂度没有达到题目要求
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);

        return nums.length % 2 == 0 ? (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0 : nums[nums.length / 2];
    }
}