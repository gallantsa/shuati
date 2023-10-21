package 贪心算法._12分发糖果._135_分发糖果;

import java.util.Arrays;

public class Main {
}

class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // 初始化每个孩子的糖果数量为1
        Arrays.fill(candies, 1);
        // 从左往右遍历, 如果右边的孩子评分比左边的高, 则右边的孩子的糖果数量为左边的孩子的糖果数量+1
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }
        // 从右往左遍历, 如果左边的孩子评分比右边的高, 且左边的孩子的糖果数量不大于右边的孩子的糖果数量, 则左边的孩子的糖果数量为右边的孩子的糖果数量+1
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
        // 返回糖果数量之和
        return Arrays.stream(candies).sum();
    }
}