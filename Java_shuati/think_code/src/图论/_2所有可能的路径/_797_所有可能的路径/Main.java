package 图论._2所有可能的路径._797_所有可能的路径;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    List<List<Integer>> ans; // 用来存放满足条件的路径
    List<Integer> cnt; // 用来保存 dfs 过程中的节点值

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        cnt = new ArrayList<>();
        cnt.add(0); // 注意: 0号节点要先加入 cnt 数组中, 因为是从 0 号节点开始的
        dfs(graph, 0);
        return ans;
    }

    private void dfs(int[][] graph, int node) {
        // 如果当前节点是目标节点, 就将 cnt 数组中的元素加入 ans 中
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(cnt));
            return;
        }

        // 遍历当前节点的所有邻接节点
        for (int i = 0; i < graph[node].length; i++) {
            // 将邻接节点加入 cnt 数组中
            cnt.add(graph[node][i]);
            // 递归
            dfs(graph, graph[node][i]);
            // 回溯
            cnt.remove(cnt.size() - 1);
        }
    }
}