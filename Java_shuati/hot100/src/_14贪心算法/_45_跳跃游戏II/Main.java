package _14贪心算法._45_跳跃游戏II;

public class Main {
}

class Solution {
    // 贪心算法
    // 每次都跳到能跳的最远的位置
    public int jump(int[] nums) {

        // 1. 定义跳跃次数
        int jumpCount = 0;

        // 2. 定义当前位置
        int curPosition = 0;

        // 3. 定义最远距离
        int maxDistance = 0;

        // 4. 遍历数组
        for (int i = 0; i < nums.length - 1; i++) {

            // 5. 更新最远距离
            maxDistance = Math.max(maxDistance, i + nums[i]);

            // 6. 如果当前位置等于i, 说明需要跳跃
            if (curPosition == i) {
                // 7. 更新当前位置
                curPosition = maxDistance;
                // 8. 更新跳跃次数
                jumpCount++;
            }
        }

        // 9. 返回跳跃次数
        return jumpCount;
    }
}