package 图论._9太平洋大西洋水流问题._417_太平洋大西洋水流问题_广搜版;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
}

class Solution {
    // 方向
    public static final int[][] positions = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };
    // 本体思路, 把不同海洋边沿的水逆流而上看能否到达对岸
    // 如果哪个地方的水能同时到达两个海洋, 则记录陆地的位置
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowSize = heights.length, colSize = heights[0].length;

        List<List<Integer>> ans   = new ArrayList<>();
        // 记录 [row, col] 位置是否可以到某条河，可以为 true，反之为 false；
        // 假设太平洋的标记为 1，大西洋为 0
        boolean[][][] visited = new boolean[rowSize][colSize][2];

        for (int row = 0; row < rowSize; row++) {
            visited[row][colSize - 1][0] = true;
            visited[row][0][1] = true;
            bfs(heights, row, colSize - 1, 0, visited);
            bfs(heights, row, 0, 1, visited);
        }

        for (int col = 0; col < colSize; col++) {
            visited[0][col][1] = true;
            visited[rowSize - 1][col][0] = true;
            bfs(heights, 0, col, 1, visited);
            bfs(heights, rowSize - 1, col, 0, visited);
        }

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                // 如果该位置即可以到太平洋又可以到大西洋，就放入答案数组
                if (visited[row][col][0] && visited[row][col][1]) {
                    ans.add(List.of(row, col));
                }
            }
        }
        return ans;
    }

    /**
     * @param heights 题目给定的二维数组
     * @param row 当前位置的行号
     * @param col 当前位置的列号
     * @param sign 记录是哪一条河，两条河中可以一个为 0，一个为 1
     * @param visited 记录这个位置可以到哪条河
     */
    private void bfs(int[][] heights, int row, int col, int sign, boolean[][][] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(row);
        queue.offer(col);

        while (!queue.isEmpty()) {
            int curRow = queue.poll();
            int curCol = queue.poll();

            for (int[] current : positions) {
                int nextRow = curRow + current[0];
                int nextCol = curCol + current[1];

                // 越界
                if (!inArea(heights, nextRow, nextCol)) continue;
                // 如果已经访问过了, 就不用再次入队
                if (visited[nextRow][nextCol][sign]) continue;
                // 如果当前位置的高度大于等于下一个位置的高度, 就不用再次入队
                if (heights[curRow][curCol] > heights[nextRow][nextCol]) continue;

                // 如果是'O', 就将其变为'A', 并入队
                visited[nextRow][nextCol][sign] = true;
                queue.offer(nextRow);
                queue.offer(nextCol);
            }
        }
    }

    private boolean inArea(int[][] heights, int row, int col) {
        if (row >= 0 && row < heights.length && col >= 0 && col < heights[0].length) return true;
        return false;
    }
}
