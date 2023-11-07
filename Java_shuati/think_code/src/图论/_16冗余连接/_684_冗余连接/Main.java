package 图论._16冗余连接._684_冗余连接;

public class Main {
}


class Solution {
    // 本题思路, 使用并查集, 将所有边合并, 如果两个节点已经在同一个集合, 就说明新的这条边是多余的
    public int[] findRedundantConnection(int[][] edges) {
        int[] root = new int[edges.length + 1];
        init(root, edges.length);

        for (int[] edge : edges) {
            if (isSameRoot(root, edge[0], edge[1])) {
                return edge;
            }
            join(root, edge[0], edge[1]);
        }

        return new int[0];
    }

    // 合并在一条边两端的两个节点
    private void join(int[] root, int point1, int point2) {
        int root1 = findRoot(root, point1);
        int root2 = findRoot(root, point2);
        if (root1 != root2) {
            root[root1] = root2;
        }
    }

    // 判断两个节点是否在同一个集合
    private boolean isSameRoot(int[] root, int point1, int point2) {
        return findRoot(root, point1) == findRoot(root, point2);
    }

    // 查找根节点
    private int findRoot(int[] root, int point) {
        if (root[point] == point) {
            return point;
        }
        return findRoot(root, root[point]);
    }

    // 初始化并查集
    private void init(int[] root, int i) {
        for (int j = 1; j <= i; j++) {
            root[j] = j;
        }
    }
}