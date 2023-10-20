package 贪心算法._7跳跃游戏._55_跳跃游戏;

public class Main {
}

class Solution {
    // 贪心算法
    // 局部最优解: 当前位置能到达的最大覆盖范围
    // 全局最优解: 最大覆盖范围大于等于数组长度
    public boolean canJump(int[] nums) {
        // 如果数组长度为1, 则返回true
        if (nums.length == 1) return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            // 更新最大覆盖范围
            cover = Math.max(cover, i + nums[i]);
            // 如果最大覆盖范围大于等于数组长度, 则返回true
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}