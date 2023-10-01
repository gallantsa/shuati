package 数组.有序数组的平方._977有序数组的平方;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        for (int i = 0; i < ints.length; i++) {
            System.out.printf("%d ", ints[i]);
        }
    }
}
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ints = new int[nums.length];
        int l = 0, r = nums.length - 1;
        int i = nums.length - 1;
        while(l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                ints[i--] = nums[l] * nums[l];
                l ++;
            } else {
                ints[i--] = nums[r] * nums[r];
                r --;
            }
        }
        return ints;
    }
}