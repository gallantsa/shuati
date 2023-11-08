package _2双指针._283_移动零;

public class Main {
}

class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        // fast指针向后遍历，遇到非0元素就和slow指针指向的元素交换
        for (; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                // 交换
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }
}