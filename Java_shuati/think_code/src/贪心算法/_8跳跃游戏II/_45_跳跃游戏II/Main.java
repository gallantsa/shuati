package 贪心算法._8跳跃游戏II._45_跳跃游戏II;

public class Main {
}

class Solution {
    // 贪心算法
    // 局部最优解: 当前位置能到达的最大覆盖范围
    // 全局最优解: 跳跃次数
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        // cover为当前位置能到达的最大覆盖范围
        int cover = 0;
        // step为跳跃次数
        int step = 0;
        // maxCover为当前位置能到达的最大覆盖范围
        int maxCover = 0;
        for (int i = 0; i <= cover; i++) {
            // 更新最大覆盖范围
            maxCover = Math.max(maxCover, i + nums[i]);
            // 如果最大覆盖范围大于等于数组长度, 则返回跳跃次数加一
            if (maxCover >= nums.length - 1) return step + 1;
            // 如果当前位置能到达的最大覆盖范围等于当前位置, 则更新最大覆盖范围, 并且跳跃次数加一
            if (i == cover) {
                cover = maxCover;
                step ++;
            }
        }
        return step;
    }
}