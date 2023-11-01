package 图论._6岛屿的最大面积._695_岛屿的最大面积_广搜版;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
}

class Solution {
    // 用来标记当前位置是否被访问过
    boolean[][] visited;
    // 用来表示方向
    int move[][] = {
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
            for (int j = 0; j < grid[0].length ; j++) {
                // 如果当前位置没有被访问过，并且当前位置是陆地，就进行 bfs
                if ((!visited[i][j]) && grid[i][j] == 1) {
                    count = 0;
                    bfs(grid, i, j);
                    // 更新岛屿的最大面积
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    private void bfs(int[][] grid, int x, int y) {
        // 将当前位置加入队尾
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        queue.offer(y);
        // 标记当前位置已经被访问过
        visited[x][y] = true;
        // 岛屿的面积加 1
        count ++;

        // 队列不为空时，循环
        while (!queue.isEmpty()) {
            int curX = queue.poll();
            int curY = queue.poll();

            // 遍历当前位置的四个方向
            for (int i = 0; i < 4; i++) {
                // 计算新的坐标
                int newX = curX + move[i][0];
                int newY = curY + move[i][1];

                // 如果新的坐标在合法范围内并且没有被访问过，并且是陆地，就将新的坐标加入队尾，并标记已经被访问过
                if (inArea(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] == 1) {
                    queue.offer(newX);
                    queue.offer(newY);
                    // 标记新的坐标已经被访问过
                    visited[newX][newY] = true;
                    count ++;
                }
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