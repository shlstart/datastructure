package class12;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: shlstart
 * Create: 2022-09-14
 */
public class Code03_EncodeNaryTreeToBinaryTree {
    public static class Node {
        int val;
        List<Node> children;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode head = new TreeNode((root.val));
        head.left = en(root.children);
        return head;
    }
    private TreeNode en(List<Node> children) {
        TreeNode head = null;
        TreeNode cur = null;
        for (Node child : children) {
            TreeNode tNode = new TreeNode(child.val);
            if (head == null) {
                head = tNode;
            } else {
                cur.right = tNode;
            }
            cur = tNode;
            //next level
            cur.left = en(child.children);
        }
        return head;
    }

    public Node decode(TreeNode root) {
        if (root == null) return null;
        return new Node(root.val, de(root.left));
    }

    public List<Node> de(TreeNode root) {
        List<Node> children = new ArrayList<>();
        while (root != null) {
            Node cur = new Node(root.val, de(root.left));
            children.add(cur);
            root = root.right;
        }
        return children;

    }
}