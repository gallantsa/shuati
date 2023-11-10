package _6矩阵._73_矩阵置零;

public class Main {
}

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 1. 先遍历第一行和第一列, 如果有0, 则将对应的行和列置为0
        boolean rowFlag = false;
        boolean colFlag = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        // 2. 遍历除第一行和第一列以外的其他行和列, 如果有0, 则将对应的行和列的第一个元素置为0
        // 用第一行和第一列来标记该行和该列是否有0
        // 从第二行和第二列开始遍历
        for (int i = 1; i < m; i++) {
            // 从第二列开始遍历
            for (int j = 1; j < n; j++) {
                // 如果当前元素为0, 则将对应的行和列的第一个元素置为0
                if (matrix[i][j] == 0) {
                    // 将对应的行和列的第一个元素置为0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. 遍历除第一行和第一列以外的其他行和列, 如果对应的行或列的第一个元素为0, 则将当前元素置为0
        // 从第二行和第二列开始遍历
        for (int i = 1; i < m; i++) {
            // 从第二列开始遍历
            for (int j = 1; j < n; j++) {
                // 如果对应的行或列的第一个元素为0, 则将当前元素置为0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    // 将当前元素置为0
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. 最后根据rowFlag和colFlag来判断第一行和第一列是否需要置为0
        if (rowFlag) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}