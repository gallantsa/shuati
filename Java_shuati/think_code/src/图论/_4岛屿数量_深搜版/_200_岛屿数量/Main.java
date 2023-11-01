package 图论._4岛屿数量_深搜版._200_岛屿数量;

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

    public int numIslands(char[][] grid) {
        int count = 0;
        visited = new boolean[grid.length][grid[0].length];

        // 遍历每一个位置
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果当前位置没有被访问过，并且当前位置是陆地，就进行 dfs
                if ((!visited[i][j]) && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    // 每次 dfs 结束后，岛屿数量加 1, 也就是说，每次 dfs 都是从一个新的岛屿开始的
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        // 如果当前位置已经被访问过，或者当前位置是海洋，就直接返回
        if (visited[x][y] || grid[x][y] == '0') return;

        // 标记当前位置已经被访问过
        visited[x][y] = true;
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
    private boolean inArea(char[][] grid, int newX, int newY) {
        // 如果新的坐标在合法范围内，就返回 true
        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
            return true;
        }
        return false;
    }
}