package _2双指针._15_三数之和;

import java.util.*;

public class Main {
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 排序后，如果当前元素大于0，那么后面的元素都大于0，不可能凑成和为0的三元组
            if (nums[i] > 0) {
                break;
            }

            // 去重 - 不能出现重复的三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right --;
                } else if (sum < 0) {
                    left ++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重 - 不能出现重复的三元组
                    while (left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    left ++;
                    right --;
                }
            }
        }
        return res;
    }
}
