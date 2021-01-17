package review.一月.recursion;

import leetcode.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 **/
public class _297_二叉树的序列化与反序列化 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> supQueue = new LinkedList<>();
        supQueue.offer(root);
        StringBuilder stb = new StringBuilder();
        stb.append("[");
        while (!supQueue.isEmpty()) {
            TreeNode node = supQueue.poll();
            if (node != null ){
                stb.append(node.val);
                supQueue.offer(node.left);
                supQueue.offer(node.right);
            }else {
                stb.append("null");
            }
            stb.append(",");
        }
        if (stb.charAt(stb.length() -1 ) == ',') {
            stb.deleteCharAt(stb.length() -1 );
        }
        stb.append("]");
        return stb.toString();
    }


    public static void main(String[] args) {
        _297_二叉树的序列化与反序列化 v = new _297_二叉树的序列化与反序列化();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = v.serialize(root);
        System.out.println(serialize);
        System.out.println(v.serialize(v.deserialize(serialize)));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodeStrArray = data.replace("[","").replace("]","").split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodeStrArray[0]));
        Queue<TreeNode> supNodeQueue = new LinkedList<>();
        supNodeQueue.offer(root);

        int curror= 1;
        while (!supNodeQueue.isEmpty() && curror < nodeStrArray.length) {


            TreeNode poll = supNodeQueue.poll();

            String nodeLeftVal = nodeStrArray[curror++];
            if (!nodeLeftVal.equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodeLeftVal));
                poll.left = leftNode;
                supNodeQueue.offer(leftNode);
            }

            String rightNodeVal = nodeStrArray[curror++];
            if (!rightNodeVal.equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(rightNodeVal));
                poll.right = right;
                supNodeQueue.offer(right);
            }
        }


        return root;
    }
}
