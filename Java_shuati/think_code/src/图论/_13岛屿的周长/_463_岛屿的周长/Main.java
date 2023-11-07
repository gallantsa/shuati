package 图论._13岛屿的周长._463_岛屿的周长;

public class Main {
}

class Solution {
    // 方向
    private final int[][] directions = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    // 本题思路, 遍历每一个格子, 如果是陆地, 就遍历四个方向, 如果新的坐标不在地图内, 或者新的坐标是海洋, 就将结果加一
    public int islandPerimeter(int[][] grid) {
        // 结果
        int result = 0;
        // 遍历每一个格子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                // 如果当前格子是陆地
                if (grid[j][i] == 1) {
                    // 遍历当前格子的四个方向
                    for (int[] direction : directions) {
                        // 计算新的坐标
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        // 如果新的坐标不在地图内, 或者新的坐标是海洋, 就将结果加一
                        if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid.length || grid[newY][newX] == 0) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}