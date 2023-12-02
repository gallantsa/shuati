package _2023._12._3._1423_可获得的最大点数;

public class Main {
}

class Solution {
    // 滑动窗口
    // 从前面移除一个元素，再从后面添加一个元素
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // 计算前k个元素的和
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        // 记录最大的和
        int maxSum = sum;
        // 从前k个元素中依次移除一个元素，再从后面添加一个元素
        for (int i = 0; i < k; i++) {
            // 从前面移除一个元素
            sum -= cardPoints[k - i - 1];
            // 从后面添加一个元素
            sum += cardPoints[n - i - 1];
            // 更新最大的和
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}