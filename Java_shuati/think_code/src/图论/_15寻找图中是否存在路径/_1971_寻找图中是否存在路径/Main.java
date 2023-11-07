package 图论._15寻找图中是否存在路径._1971_寻找图中是否存在路径;

public class Main {
}

class Solution {
    // 本题思路, 使用并查集, 将所有边合并, 然后判断两个节点是否在同一个集合
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] root = new int[n];
        init(root, n);

        for (int[] edge : edges) {
            join(root, edge[0], edge[1]);
        }

        return isSameRoot(root, source, destination);
    }

    // 初始化并查集
    private void init(int[] root, int n) {
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    // 查找根节点
    private int findRoot(int[] root, int i) {
        return root[i] == i ? i : findRoot(root, root[i]);
    }

    // 合并在一条边两端的两个节点
    private void join(int[] root, int point1, int point2) {
        int root1 = findRoot(root, point1);
        int root2 = findRoot(root, point2);
        // 如果两个节点不在同一个集合, 就合并
        if (root1 != root2) {
            root[root1] = root2;
        }
    }

    // 判断两个节点是否在同一个集合
    private boolean isSameRoot(int[] root, int source, int destination) {
        return findRoot(root, source) == findRoot(root, destination);
    }
}