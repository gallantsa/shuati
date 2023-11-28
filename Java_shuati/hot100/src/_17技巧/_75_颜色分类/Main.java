package _17技巧._75_颜色分类;

public class Main {
}

class Solution {
    public void sortColors(int[] nums) {
        // 定义三个指针
        // p0指向0的最右边界
        // p2指向2的最左边界
        // cur指向当前元素
        int p0 = 0;
        int p2 = nums.length - 1;
        int cur = 0;

        // 遍历数组
        while (cur <= p2) {
            // 如果当前元素为0
            if (nums[cur] == 0) {
                // 交换当前元素和p0指向的元素
                swap(nums, cur, p0);
                // p0指针右移
                p0++;
                // cur指针右移
                cur++;
            } else if (nums[cur] == 2) {
                // 如果当前元素为2
                // 交换当前元素和p2指向的元素
                swap(nums, cur, p2);
                // p2指针左移
                p2--;
            } else {
                // 如果当前元素为1
                // cur指针右移
                cur++;
            }
        }
    }

    // 交换数组中的两个元素
    private void swap(int[] nums, int i, int j) {
        // 交换数组中的两个元素
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}