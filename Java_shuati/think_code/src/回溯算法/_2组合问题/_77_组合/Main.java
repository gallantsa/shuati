package 回溯算法._2组合问题._77_组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    /**
     * 回溯求组合
     * @param n n个数
     * @param k k个为一组进行组合
     * @param startIndex 控制树叉
     */
    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        // for控制层数
        for (int j = startIndex; j <= n; j++) {
            path.add(j);
            backtracking(n, k, j + 1);
            path.removeLast();
        }
    }
}