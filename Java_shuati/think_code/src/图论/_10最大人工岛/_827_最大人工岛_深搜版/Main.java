package 图论._10最大人工岛._827_最大人工岛_深搜版;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
}

class Solution {
    private static final int[][] position = {
            {-1, 0}, // 上
            {0, 1}, // 右
            {1, 0}, // 下
            {0, -1} // 左
    };

    // 本题思路, 先将所有的岛屿标记为不同的数字, 然后遍历所有的海洋, 看看哪个海洋可以连接最多的岛屿
    public int largestIsland(int[][] grid) {
        int ans = Integer.MIN_VALUE;
        int size = grid.length;
        int mark = 2;
        Map<Integer, Integer> getSize = new HashMap<>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // 如果是陆地, 就进行深搜, 并且记录当前岛屿的面积
                if (grid[row][col] == 1) {
                    int areaSize = 1 + dfs(grid, row, col, mark);
                    getSize.put(mark++, areaSize);
                }
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // 如果当前位置不是海洋, 就跳过
                if (grid[row][col] != 0) continue;
                Set<Integer> hashSet = new HashSet<>();

                int curSize = 1;
                // 遍历当前海洋的四个方向
                for (int[] current : position) {
                    int curRow = row + current[0];
                    int curCol = col + current[1];
                    // 如果当前位置不在地图内, 或者当前位置已经被标记过, 或者当前位置不是岛屿, 就跳过
                    if (!inArea(grid, curRow, curCol)) continue;
                    int curMark = grid[curRow][curCol];
                    if (hashSet.contains(curMark) || !getSize.containsKey(curMark)) continue;
                    // 如果当前位置是岛屿, 就将当前岛屿的面积加到当前海洋的面积上
                    hashSet.add(curMark);
                    curSize += getSize.get(curMark);
                }
                // 更新最大值
                ans = Math.max(ans, curSize);
            }
        }
        // 如果没有海洋, 就返回整个地图的面积
        // 为什么ans == Integer.MIN_VALUE 表示没有海洋
        // 因为如果没有海洋, 那么ans就不会被更新, 也就是说ans还是Integer.MIN_VALUE
        return ans == Integer.MIN_VALUE ? size * size : ans;
    }

    private int dfs(int[][] grid, int row, int col, int mark) {
        int ans = 0;
        // 标记当前位置
        grid[row][col] = mark;
        // 遍历当前位置的四个方向
        for (int[] current : position) {
            int curRow = row + current[0];
            int curCol = col + current[1];
            if (!inArea(grid, curRow, curCol)) continue;
            // 如果当前位置是陆地, 就累加面积
            if (grid[curRow][curCol] == 1)
                ans += 1 + dfs(grid, curRow, curCol, mark);
        }
        // 返回当前岛屿的面积
        return ans;
    }

    /**
     * 判断当前位置是否在地图内
     * @param grid
     * @param curRow
     * @param curCol
     * @return
     */
    private boolean inArea(int[][] grid, int curRow, int curCol) {
        if (curRow >= 0 && curRow < grid.length && curCol >= 0 && curCol < grid.length) return true;
        return false;
    }
}