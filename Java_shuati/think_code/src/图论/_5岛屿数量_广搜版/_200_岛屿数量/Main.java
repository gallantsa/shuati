package 图论._5岛屿数量_广搜版._200_岛屿数量;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
}

class Solution {
    boolean[][] visited;
    int move[][] = {
            {0, 1}, // 下
            {0, -1}, // 上
            {1, 0}, // 右
            {-1, 0} // 左
    };
    public int numIslands(char[][] grid) {
          int count = 0;
            visited = new boolean[grid.length][grid[0].length];

            // 遍历每一个位置
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length ; j++) {
                    // 如果当前位置没有被访问过，并且当前位置是陆地，就进行 bfs
                    if ((!visited[i][j]) && grid[i][j] == '1') {
                        bfs(grid, i, j);
                        // 每次 bfs 结束后，岛屿数量加 1, 也就是说，每次 bfs 都是从一个新的岛屿开始的
                        count++;
                    }
                }
            }
            return count;
    }

    private void bfs(char[][] grid, int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        // 将当前位置加入队尾
        queue.offer(new int[]{y, x});
        // 标记当前位置已经被访问过
        visited[y][x] = true;
        // 队列不为空时，循环
        while (!queue.isEmpty()) {
            // 取出队首元素
            int[] cur = queue.poll();
            // 遍历当前位置的四个方向
            for (int i = 0; i < 4; i++) {
                // 计算新的坐标
                int newY = cur[0] + move[i][0];
                int newX = cur[1] + move[i][1];

                // 如果新的坐标在合法范围内并且没有被访问过，并且是陆地，就将新的坐标加入队尾，并标记已经被访问过
                if (inArea(grid, newY, newX) && !visited[newY][newX] && grid[newY][newX] == '1') {
                    queue.offer(new int[]{newY, newX});
                    visited[newY][newX] = true;
                }
            }
        }
    }

    /**
     * 判断新的坐标是否在合法范围内
     * @param grid
     * @param newY
     * @param newX
     * @return
     */
    private boolean inArea(char[][] grid, int newY, int newX) {
        if (newY >= 0 && newY < grid.length && newX >= 0 && newX < grid[0].length) {
            return true;
        }
        return false;
    }
}