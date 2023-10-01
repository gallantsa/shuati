package 数组.螺旋矩阵II._54螺旋矩阵;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int n = matrix.length, m = matrix[0].length;
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        boolean[][] status = new boolean[n][m];
        for (int i = 0, x = 0, y = 0, a, b, d = 0, k = n * m; i < k; ++i) {
            res.add(matrix[x][y]);
            status[x][y] = true;
            a = x + dx[d];
            b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= m || status[a][b]) {
                d = (d + 1) % dx.length;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }
}