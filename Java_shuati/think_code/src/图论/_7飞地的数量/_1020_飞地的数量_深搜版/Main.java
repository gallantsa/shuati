package 图论._7飞地的数量._1020_飞地的数量_深搜版;

public class Main {
}

// 淹没岛屿优化, 没有visited数组
class Solution {
    // 记录飞地数量
    int count = 0;
    // 方向数组
    int[][] dir = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    public int numEnclaves(int[][] grid) {
        // 与地图边沿接壤的陆地一定不满足条件, 被淹没!
        for (int i = 0; i < grid.length; i++) {
            // 遍历第一列
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            // 遍历最后一列
            if (grid[i][grid[0].length - 1] == 1) {
                dfs(grid, i, grid[0].length - 1);
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            // 遍历第一行
            if (grid[0][i] == 1) {
                dfs(grid, 0, i);
            }
            // 遍历最后一行
            if (grid[grid.length - 1][i] == 1) {
                dfs(grid, grid.length - 1, i);
            }
        }
        // 重置count为0
        count = 0;
        // 剩下的陆地都是不与地图边沿陆地接壤的
        // 每当遍历到岛屿, 总飞地数+1
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) return;

        // 陆地被淹没
        grid[x][y] = 0;
        count ++;

        for (int i = 0; i < 4; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];

            if (!inArea(grid, newX, newY)) {
                continue;
            }

            dfs(grid, newX, newY);
        }
    }

    /**
     * 陆地在合法区域内
     * @param grid
     * @param newX
     * @param newY
     * @return
     */
    private boolean inArea(int[][] grid, int newX, int newY) {
        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
            return true;
        }
        return false;
    }
}