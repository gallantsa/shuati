package 数组.螺旋矩阵II._59螺旋矩阵II;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1;
        for (int i = 1; i <= n * n; i ++ ) {
            res[x][y] = i;
            int a = x + dx[d], b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= n || res[a][b] > 0) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }
}
