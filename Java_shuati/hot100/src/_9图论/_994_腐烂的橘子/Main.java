package _9图论._994_腐烂的橘子;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        Solution solution = new Solution();
        int res = solution.orangesRotting(grid);
        System.out.println(res);
    }
}

class Solution {
    // 本题采用BFS
    public int orangesRotting(int[][] grid) {
        // 方向数组
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        // 记录时间
        int res  = 0;
        int m = grid.length, n = grid[0].length;

        LinkedList<int[]> queue = new LinkedList<>();

        // 遍历每一个格子, 将腐烂的橘子加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (2 == grid[i][j]) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS
        while (!queue.isEmpty()) {
            int sz = queue.size();
            // 每一层的橘子都会腐烂, 所以时间加1
            res++;
            // 遍历当前层的所有节点
            for (int i = 0; i < sz; i++) {
                int[] cur = queue.poll();
                // 遍历当前节点的上下左右, 将新鲜的橘子加入队列, 并标记为腐烂
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + dirs[k][0], y = cur[1] + dirs[k][1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (1 == grid[x][y]) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        // 遍历每一个格子, 如果还有新鲜的橘子, 返回-1
        for (int[] row : grid) {
            for (int col : row) {
                if (1 == col) {
                    return -1;
                }
            }
        }

        // 如果没有新鲜的橘子, 返回时间
        return res == 0 ? 0 : res - 1;
    }
}