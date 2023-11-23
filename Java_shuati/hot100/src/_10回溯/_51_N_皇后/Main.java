package _10回溯._51_N_皇后;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('.');
        }
        for (int i = 0; i < n; i++) {
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(List<String> board, int row) {
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        // 遍历每一列
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 如果当前位置不合法, 直接跳过
            if (!isValid(board, row, col)) continue;

            // 将当前位置标记为皇后
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());

            // 递归
            backtrack(board, row + 1);

            // 回溯
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }

    }

    private boolean isValid(List<String> board, int row, int col) {
        int n = board.size();

        for (int i = 0; i <= row; i++) {
            //判断当前列有没有皇后,因为他是一行一行往下走的，
            //我们只需要检查走过的行数即可，通俗一点就是判断当前
            //坐标位置的上面有没有皇后
            if (board.get(i).charAt(col) == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            // 检查当前坐标右上方是否有皇后互相冲突
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            // 检查当前坐标左上方是否有皇后互相冲突
            if (board.get(i).charAt(j) == 'Q') return false;
        }

        return true;
    }
}