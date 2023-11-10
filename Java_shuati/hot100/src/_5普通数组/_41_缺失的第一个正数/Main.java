package _5普通数组._41_缺失的第一个正数;

import java.util.Arrays;

public class Main {
}

class Solution {
    // 解题思路: 先排序, 再遍历
    // 初始化res = 1
    // 遍历数组, 如果当前元素等于res, 则res++
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for (int num : nums) {
            if (num == res) {
                res ++;
            }
        }
        return res;
    }
}