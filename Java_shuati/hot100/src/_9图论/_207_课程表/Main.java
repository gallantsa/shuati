package _9图论._207_课程表;

import java.util.LinkedList;
import java.util.List;

public class Main {
}

// 本题采用DFS + 拓扑排序
// 拓扑排序可以用来判断有向图是否有环
class Solution {
    // 记录一次 traverse 递归经过的节点
    boolean[] onPath;

    // 记录是否访问过
    boolean[] visited;

    // 记录是否有环
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        // 初始化
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        // 遍历每一个节点
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        // 如果有环, 返回false
        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int i) {
        // 如果已经有环, 直接返回
        if (onPath[i]) {
            hasCycle = true;
            return;
        }

        // 如果已经访问过, 直接返回
        if (visited[i]) return;

        // 标记为已访问
        visited[i] = true;
        // 标记为在当前路径上
        onPath[i] = true;

        // 遍历当前节点的所有邻接节点
        for (int j : graph[i]) {
            traverse(graph, j);
        }
        // 从当前路径上移除
        onPath[i] = false;
    }

    /**
     * 构建图
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}