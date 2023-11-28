package _17技巧._31_下一个排列;

public class Main {
}

class Solution {
    public void nextPermutation(int[] nums) {
        // 从后往前找到第一个相邻的升序对(i, i + 1)
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            // 如果找不到，说明当前排列为最大排列
            // 直接翻转数组
            i--;
        }

        // 如果找到了，从后往前找到第一个大于nums[i]的元素
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                // 如果找不到，说明当前排列为最大排列
                // 直接翻转数组
                j--;
            }
            // 交换nums[i]和nums[j]
            swap(nums, i, j);
        }
        // 翻转nums[i + 1]到nums[nums.length - 1]
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int i) {
        // 翻转数组
        int left = i, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++; right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        // 交换数组中的两个元素
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}