package 图论._6岛屿的最大面积._695_岛屿的最大面积_深搜版;

public class Main {
}

class Solution {
    // 定义一个二维数组，用来标记某个位置是否被访问过
    boolean[][] visited;
    // 定义一个二维数组，用来表示方向
    int dir[][] = {
            {0, 1}, // 右
            {1, 0}, // 下
            {0, -1}, // 左
            {-1, 0} // 上
    };
    // 记录岛屿的面积
    int count;
    public int maxAreaOfIsland(int[][] grid) {
        // 记录岛屿的最大面积
        int res = 0;
        visited = new boolean[grid.length][grid[0].length];
        // 遍历每一个位置
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果当前位置已经被访问过，或者当前位置是海洋，就直接返回
                if (visited[i][j] || grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j);
                    // 更新岛屿的最大面积
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        // 如果当前位置已经被访问过，或者当前位置是海洋，就直接返回
        if (visited[x][y] || grid[x][y] == 0) return;
        // 标记当前位置已经被访问过
        visited[x][y] = true;
        // 岛屿的面积加 1
        count++;
        // 遍历当前位置的四个方向
        for (int i = 0; i < 4; i++) {
            // 计算新的坐标
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            // 如果新的坐标在合法范围内，就进行 dfs
            if (inArea(grid, newX, newY)) {
                dfs(grid, newX, newY);
            }
        }
    }

    /**
     * 判断新的坐标是否在合法范围内
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