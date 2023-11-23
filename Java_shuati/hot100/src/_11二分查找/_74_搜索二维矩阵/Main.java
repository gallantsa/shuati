package _11二分查找._74_搜索二维矩阵;

public class Main {
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 把二维数组映射的一维数组
        int left  = 0;
        int right = m * n - 1;

        // 二分查找
        // 搜索区间为[left, right]
        while (left <= right) {
            // 防止如果left和right都很大时, left + right会溢出
            int mid = left + (right - left) / 2;

            if (get(matrix, mid) == target) {
                return true;
            } else if (get(matrix, mid) < target) {
                left = mid + 1;
            } else if (get(matrix, mid) > target) {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 将一维的index转换为二维的坐标
     * @param matrix
     * @param index
     * @return
     */
    // 通过一维坐标访问二维数组的元素
    private int get(int[][] matrix, int index) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 计算二维数组的坐标
        int i = index / n;
        int j = index % n;

        return matrix[i][j];
    }
}