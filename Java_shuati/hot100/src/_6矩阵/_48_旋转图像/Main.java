package _6矩阵._48_旋转图像;

public class Main {
}

// TODO 旋转图像 待深入理解
class Solution {
    // 顺时针90度应该是左上/右下对角线翻转+左右翻转，或者右上/左下对角线翻转+上下翻转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 1. 先左上/右下对角线翻转
        for (int i = 0; i < n; i++) {
            // 注意j的起始位置
            for (int j = i; j < n; j++) {
                // 交换matrix[i][j]和matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 再左右翻转
        for (int i = 0; i < n; i++) {
            // 注意j的起始位置
            for (int j = 0; j < n / 2; j++) {
                // 交换matrix[i][j]和matrix[i][n - 1 - j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n- 1 - j] = temp;
            }
        }
    }
}