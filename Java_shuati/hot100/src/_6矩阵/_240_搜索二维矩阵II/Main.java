package _6矩阵._240_搜索二维矩阵II;

public class Main {
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] > target)
                    break;
            }
        }
        return flag;
    }
}