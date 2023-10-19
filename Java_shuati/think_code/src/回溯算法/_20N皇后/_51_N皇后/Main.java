package 回溯算法._20N皇后._51_N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
}

class Solution {
    List<List<String>> result = new ArrayList<>();
    char[][] chessboard;
    public List<List<String>> solveNQueens(int n) {
        chessboard = new char[n][n];
        // 初始化棋盘
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTracking(n, 0);
        return result;
    }

    private void backTracking(int n, int row) {
        if (row == n) {
            result.add(Array2List());
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n)) {
                chessboard[row][col] = 'Q';
                // row是控制树遍历到了第几行
                backTracking(n, row + 1);
                chessboard[row][col] = '.';
            }
        }
    }

    private List<String> Array2List() {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            // String.copyValueOf(char[] data) 方法返回一个新的 String ，它包含来自字符数组参数的字符副本。
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    private boolean isValid(int row, int col, int n) {
        // 检查列
        // 如果在同一列上有皇后, 则不合法
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线(左上到右下)
        // for循环初始化完后, 会先判断条件是否成立, 如果成立, 则执行循环体, 执行完循环体后, 再执行迭代部分
        // 因此不会出现数组越界的情况
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线(右上到左下)
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}