package _10回溯._79_单词搜索;

public class Main {
}

class Solution {

    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    boolean found = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, word, 0);
                if (found) return true;
            }
        }
        return false;
    }

    // 从board[i][j]开始, 寻找word[p..]
    // p表示当前已经匹配到word的第几个字符
    private void dfs(char[][] board, int i, int j, String word, int p) {
        // 如果已经找到, 直接返回
        if (p == word.length()) {
            found = true;
            return;
        }
        if (found) return;

        int m = board.length, n = board[0].length;

        // 如果越界, 直接返回
        if (i < 0 || i >= m || j < 0 || j >= n) return;

        // 如果当前字符不匹配, 直接返回
        if (board[i][j] != word.charAt(p)) return;

        // 标记为已访问
        // 为了防止重复访问, 将board[i][j]取反
        // 取反之后的值一定是负数, 因为board[i][j]的值一定是字母, 而字母的ASCII码一定是正数
        board[i][j] = (char)(-board[i][j]);
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1], word, p + 1);
        }
        // 恢复
        board[i][j] = (char)(-board[i][j]);
    }
}