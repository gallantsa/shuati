package 哈希表._8三数之和._15三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return result;

            // 去重a
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (right > left) {
                if (nums[i] + nums[left] + nums[right] > 0) right --;
                else if (nums[i] + nums[left] + nums[right] < 0) left ++;
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1]) right --;
                    while (right > left && nums[right] == nums[left + 1]) left ++;

                    right --;
                    left ++;
                }
            }
        }
        return result;
    }
}