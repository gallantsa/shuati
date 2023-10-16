package 回溯算法._3组合_优化._77_组合;

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
        // 剪枝
        // 已经选择的元素个数：path.size();
        // 所需需要的元素个数为: k - path.size();
        // 列表中剩余元素（n-i） >= 所需需要的元素个数（k - path.size()）
        // 在集合n中至多要从该起始位置 : i <= n - (k - path.size()) + 1，开始遍历
        for (int j = startIndex; j <= n - (k - path.size()) + 1; j++) {
            path.add(j);
            backtracking(n, k, j + 1);
            path.removeLast();
        }
    }
}