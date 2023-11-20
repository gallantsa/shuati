package _9图论._200_岛屿数量;

public class Main {
}

class Solution {
    // 上下左右
    int [][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;

        // 遍历每一个格子
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // 如果越界, 或者当前格子是水, 直接返回
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == '0') return;

        // 将当前格子标记为水
        grid[i][j] = '0';

        // 遍历当前格子的上下左右
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k][0], y = j + dirs[k][1];
            dfs(grid, x, y);
        }
    }
}