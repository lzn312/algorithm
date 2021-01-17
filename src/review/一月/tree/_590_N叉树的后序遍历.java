package review.一月.tree;

import leetcode.top100.simple.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _590_N叉树的后序遍历 {

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
    }

    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();

        innerPostOrder(root, res);
        return res;
    }

    private void innerPostOrder(Node node, List<Integer> res) {
        if ( node == null ){
            return;
        }

        for (int i = 0; i < node.children.size(); i++) {
            innerPostOrder(node.children.get(i), res);
        }
        res.add(node.val);
    }

    // 迭代，迭代可以使用前序遍历的形式，但是我们加入数组的时候，总往头部添加，也能达到后序遍历的效果
    public List<Integer> postorder1(Node root) {

        LinkedList<Integer> res = new LinkedList<>();

        LinkedList<Node> supStack = new LinkedList<>();
        supStack.push(root);

        while ( !supStack.isEmpty()) {
            Node node = supStack.pollLast();
            res.addFirst(node.val);
            for (Node child : node.children) {
                if (child != null) {
                    supStack.addLast(child);
                }
            }
        }
        innerPostOrder(root, res);
        return res;
    }
}
