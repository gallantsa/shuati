package 图论._6岛屿的最大面积._695_岛屿的最大面积_DFS优化;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1},
        };
        System.out.println(new Solution().maxAreaOfIsland(grid));
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // 记录岛屿的最大面积
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果当前位置是陆地，就进行 dfs
                if (grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        // 如果当前位置已经是海洋，或者当前位置不在合法范围内，就直接返回
        if (!inArea(grid, i, j) || grid[i][j] == 0) return 0;
        // 淹没当前位置
        grid[i][j] = 0;

        // 递归淹没当前位置的上下左右四个方向
        return  1 + dfs(grid, i + 1, j) +
                    dfs(grid, i - 1, j) +
                    dfs(grid, i, j + 1) +
                    dfs(grid, i, j - 1);
    }

    /**
     * 判断新的坐标是否在合法范围内
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private boolean inArea(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }
}