package 常用容器.和为S的两个数字;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int[] findNumbersWithSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            ints[0] = nums[i];
            int res = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == res) {
                    ints[1] = nums[j];
                    return ints;
                }
            }
        }
        return ints;
    }
}