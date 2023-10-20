package 贪心算法._3摆动序列._376_摆动序列;

public class Main {
}

class Solution {
    // 贪心算法
    // 三种情况
    // 1. 上下坡有平坡
    // 2. 首尾元素 默认前面有一个元素
    // 3. 单调有平坡
    // 局部最优解: 当前差值和上一个差值异号, 则计数加一
    // 全局最优解: 计数的最大值
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return 1;
        int prediff = 0;
        int curdiff = 0;
        // count为摆动序列的长度
        int count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            curdiff = nums[i + 1] - nums[i];
            // 如果当前差值和上一个差值异号, 则计数加一
            if ((curdiff > 0 && prediff <= 0) || (curdiff < 0 && prediff >= 0)) {
                count ++;
                // 更新上一个差值
                prediff = curdiff;
            }
        }
        return count;
    }
}