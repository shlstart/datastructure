package class12;

import java.util.LinkedList;

/**
 * Author: shlstart
 * Create: 2022-09-13
 */
public class Code01_IsCBT {
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node (int data) {
            value = data;
        }
    }
    //check whether given tree is complete binary tree
    //if root.left == null, root.right != null then is false;
    //start from leaf node, rest of nodes must be leaf node
    //if leaf && root.left != || root.right != null, then is false;
    public static boolean isCBT1(Node head) {
        if (head == null) return true;
        LinkedList<Node> queue = new LinkedList<>();
        //mark starts of leaf nodes
        boolean leaf = false;
        Node left = null;
        Node right = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            if (left == null && right != null) return false;
            if (leaf && (left != null || right != null)) return false;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }

            if (left == null || right == null) leaf = true;
        }
        return true;
    }
}