package leetcode.树;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 *
 **/
public class _116_填充每个节点的下一个右侧节点指针 {


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // 这题的难点还是在如何处理跨越节点的数据，我一开始想着的是通过层序遍历解决，但是问题难点在于，只能使用常量级的额外空间
    // 所以我们可以按照正常方式处理左右节点，然后主要难点是处理两个跨越节点的数据，所以这一题的主要点可以转换到如何处理两个跨越节点的数据
    public Node connect(Node root) {
        if ( root ==  null || (root.left == null && root.right == null)) {
            return root;
        }


        connectTowNode(root.left, root.right);
        return root;
    }

    private void connectTowNode(Node left, Node right) {
        if (left == null || right == null)
            return;

        // 连接节点
        left.next = right;

        connectTowNode(left.left, left.right);
        connectTowNode(right.left, right.right);
        connectTowNode(left.right,right.left);
    }
}
