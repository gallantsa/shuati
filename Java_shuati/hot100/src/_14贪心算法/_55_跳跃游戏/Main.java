package _14贪心算法._55_跳跃游戏;

public class Main {
}

class Solution {
    // 贪心算法
    // 每次都跳到能跳的最远的位置
    public boolean canJump(int[] nums) {

        // 1. 定义最远距离
        int maxDistance = 0;

        // 2. 遍历数组
        for (int i = 0; i < nums.length; i++) {

            // 3. 如果当前位置大于最远距离, 说明无法到达当前位置, 返回false
            if (i > maxDistance) {
                return false;
            }

            // 4. 更新最远距离
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }

        // 5. 如果最远距离大于等于数组长度, 说明可以到达最后一个位置, 返回true
        return maxDistance >= nums.length - 1;
    }
}