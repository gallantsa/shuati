package _2023._12._7._1466_重新规划路线;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

/**
 既然是树形结构,那么,所有的点都是连接在一起的,就可以构建图
 根据题意,这是一个树形结构的有向无环图,如果不是树形的,比如题目变成了修路且无向的话,并查集就合适了,因为可能存在一个孤立的城市,跟任何城市可能都没关系
 另外,这个解法是建立在树的结构这个约束条件下的,如果是真正的图的话,就不正确了,因为存在这么一种情况,所有节点其实都可以到达城市0,但是在深度遍历的过程中,
 有可能某个路径是反方向的,此时计算的结果不会是0,但真正正确的答案是0
 相当于整个算法的思维是降维的,用图来解决树的问题
 */
class Solution {
    private int count; // 变更方向的路线数

    public int minReorder(int n, int[][] connections) {
        // 构建有向图
        List<List<Integer>> graph = buildGraph(n, connections);
        // 记录节点的访问状态
        boolean[] visited = new boolean[n];
        // 从节点0开始深度优先搜索
        dfs(graph, visited, 0);
        // 返回变更方向的路线数
        return count;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int city) {
        // 标记当前节点为已访问
        visited[city] = true;
        for (int neighbor : graph.get(city)) {
            // 如果邻居节点未被访问
            if (!visited[Math.abs(neighbor)]) {
                // 这里就体现出来有向的特性了,我们这个def方法,是从城市0的方向往外走的,因为整个结构是树(哪怕是多叉树,也不会有环的存在),因此从任意一个城市到达另一个城市,经过的城市是唯一的
                // ,如果neighbor>0,就说过没办法绕过其他城市抵达目标城市,必须要改路,因此count++
                if (neighbor > 0) {
                    // 需要变更方向的路线数增加
                    count++;
                }
                // 继续深度优先搜索邻居节点
                dfs(graph, visited, Math.abs(neighbor));
            }
        }
    }

    /**
     n 是顶点的个数,connections用于创建邻接表
     */
    private List<List<Integer>> buildGraph(int n, int[][] connections) {
        // 用邻接表表示有向图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 初始化每个节点的邻居列表
            graph.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            // 添加正向路线
            graph.get(from).add(to);
            // 这里有个取巧的地方,添加反向路线，使用负数表示
            graph.get(to).add(-from);
        }
        return graph;
    }
}