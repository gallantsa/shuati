package _6矩阵._54_螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int INF = 101;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0, x = 0, y = 0, d = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            // 为什么要将当前元素置为INF?
            // 因为如果不置为INF, 则会出现死循环
            // 比如:
            // 1 2 3
            // 4 5 6
            // 7 8 9
            // 当遍历到3的时候, 会将3置为INF, 然后向右遍历, 遍历到6的时候, 会将6置为INF, 然后向下遍历, 遍历到9的时候, 会将9置为INF, 然后向左遍历,
            // 遍历到8的时候, 会将8置为INF, 然后向上遍历, 遍历到3的时候, 会发现3已经是INF了, 说明已经遍历过了, 但是实际上3并没有遍历过, 所以会出现死循环
            matrix[x][y] = INF;
            int newX = x + directions[d][0];
            int newY = y + directions[d][1];
            // 如果新的坐标越界或者新的坐标的元素已经被遍历过了, 则改变方向
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || matrix[newX][newY] == INF) {
                d = (d + 1) % 4;
                newX = x + directions[d][0];
                newY = y + directions[d][1];
            }
            x = newX;
            y = newY;
        }
        return res;
    }
}