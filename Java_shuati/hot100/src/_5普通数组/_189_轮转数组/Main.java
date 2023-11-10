package _5普通数组._189_轮转数组;

import java.util.Arrays;

public class Main {
}

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        // 1. 先将整个数组反转
        reverse(nums, 0, len - 1);
        // 2. 再将前k个元素反转
        reverse(nums, 0, k - 1);
        // 3. 最后将后len-k个元素反转
        reverse(nums, k, len - 1);
    }

    /**
     * 反转数组
     * @param nums
     * @param k
     * @param i
     */
    private void reverse(int[] nums, int k, int i) {
        while (k < i) {
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
            k ++;
            i --;
        }
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        // k可能大于len
        // 需要取余
        if (k >= len) {
            k %= len;
        }
        int[] nums1 = Arrays.copyOfRange(nums, 0, len - k);
        int[] nums2 = Arrays.copyOfRange(nums, len - k, len);

        System.arraycopy(nums2, 0, nums, 0, nums2.length);
        System.arraycopy(nums1, 0, nums, nums2.length, nums1.length);
    }
}