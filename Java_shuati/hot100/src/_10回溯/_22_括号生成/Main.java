package _10回溯._22_括号生成;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();

        // 记录结果
        List<String> res = new ArrayList<>();

        // 回溯过程中的路径
        StringBuilder track = new StringBuilder();

        // 可用的左括号数量为n, 右括号数量为n
        backtrack(n, n, track, res);
        return res;
    }

    private void backtrack(int left, int right, StringBuilder track, List<String> res) {
        // 剪枝
        // 数量小于0, 一定不合法
        if (left < 0 || right < 0) return;

        // 右括号数量大于左括号数量, 一定不合法
        if (left > right) return;

        // 当所有括号都用完时, 得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        // 尝试放一个左括号
        track.append('('); // 选择
        backtrack(left - 1, right, track, res);
        track.deleteCharAt(track.length() - 1); // 撤消选择

        // 尝试放一个右括号
        track.append(')'); // 选择
        backtrack(left, right - 1, track, res);
        track.deleteCharAt(track.length() - 1); // 撤消选择
    }
}