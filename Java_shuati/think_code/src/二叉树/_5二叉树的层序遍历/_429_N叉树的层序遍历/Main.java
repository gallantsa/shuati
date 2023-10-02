package 二叉树._5二叉树的层序遍历._429_N叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();

            while (len -- > 0) {
                Node poll = queue.poll();
                itemList.add(poll.val);

                List<Node> children = poll.children;
                /*跳过没有子节点的节点，以提高效率和减少不必要的操作 */
                if(children == null || children.size() == 0) {
                    continue;
                }

                for (Node child : children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            resList.add(itemList);
        }
        return resList;
    }
}
