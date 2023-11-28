package _17技巧._169_多数元素;

public class Main {
}

class Solution {
    // 模仿粒子带点
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            // 如果 count == 0，说明之前的数字都被抵消完了
            if (count == 0) {
                // 重新开始计数
                res = num;
                count++;
            } else {
                // 如果当前数字和之前的数字相等，计数器加一
                if (num == res) {
                    count++;
                } else {
                    // 如果当前数字和之前的数字不等，计数器减一
                    count--;
                }
            }
        }
        return res;
    }
}