package _11二分查找._153_寻找旋转排序数组中的最小值;

import java.util.Arrays;

public class Main {
}

// 解题思路: 先排序, 然后返回第一个元素
// 时间复杂度: O(nlogn)
// 时间复杂度没有达到题目要求
class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}