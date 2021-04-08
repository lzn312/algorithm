package leetcode.树;

import review.一月.tree._590_N叉树的后序遍历;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 **/
public class _429_N叉树的层序遍历 {

    static class Node {
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



    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res  = new ArrayList<>();

        bfs(res,root,0);

        return res;

    }

    private void bfs(List<List<Integer>> res, Node node, Integer levelSize) {

        // 构建新的数据
        if (res.size() == levelSize) {
            res.add(new ArrayList<>());
        }
        res.get(levelSize).add(node.val);


        for (Node child : node.children) {
            bfs(res, child, levelSize + 1);
        }
    }


    public static void main(String[] args) {
        _429_N叉树的层序遍历 test = new _429_N叉树的层序遍历();
        Node root = new Node(1);
        List<Node> nodes = new ArrayList<>(3) ;
        nodes.add(new Node(3, Arrays.asList(new Node(5,new ArrayList<>()), new Node(6, new ArrayList<>()))));
        nodes.add(new Node(2,new ArrayList<>()));
        nodes.add(new Node(4, new ArrayList<>()));
        root.children = nodes;

        System.out.println(test.levelOrder(root));
    }
}
