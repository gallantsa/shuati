package 图论._8被围绕的区域._130_被围绕的区域_深搜版;

public class Main {
}

class Solution {
    int count;
    int[][] dir = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };
    // 本题的思路就是将所有地图边沿的'O'变为'A', 因此只需在遍历第一列, 最后一列, 第一行, 最后一行是需要深搜
    // 最后遍历整个地图
    // 剩下的陆地如果是'O'直接赋值为'X'
    // 如果是'A', 重新变为'O'
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            // 遍历第一列
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            // 遍历最后一列
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            // 遍历第一行
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            // 遍历最后一行
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'A' || board[x][y] == 'X') return;

        board[x][y] = 'A';

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if (!inArea(board, nextX, nextY)) continue;
            dfs(board, nextX, nextY);
        }
    }

    private boolean inArea(char[][] board, int nextX, int nextY) {
        if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length) return true;
        return false;
    }
}