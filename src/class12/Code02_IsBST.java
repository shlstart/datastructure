package class12;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: shlstart
 * Create: 2022-09-14
 */
public class Code02_IsBST {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int data) {
            value = data;
        }
    }
    //inorder traversal, collect every node into list
    //loop through each value if pre.val >= cur.val return false
    public static boolean isBST1(Node head) {
        if (head == null) return true;
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i -1).value) return false;
        }
        return true;
    }
    public static void in(Node head, List<Node> arr) {
        if (head == null) return;
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static boolean isBST2(Node head) {
        if (head == null) return true;
        return process(head).isBST;
    }

    public static class Info {
        boolean isBST;
        int max;
        int min;
        public Info(boolean i, int ma, int mi) {
            isBST = i;
            max = ma;
            min = mi;
        }
    }
    public static Info process(Node x) {
        // why return null, dont max and min in what range are
        // let caller to check return value
        if (x == null) return null;
        Info left = process(x.left);
        Info right = process(x.right);
        int max = x.value;
        if (left != null) {
            max = Math.max(max, left.max);
        }
        if (right != null) {
            max = Math.max(max, right.max);
        }
        int min = x.value;
        if (left != null) {
            min= Math.min(min, left.min);
        }
        if (right != null) {
            min = Math.min(min, right.min);
        }
        boolean isBST = true;
        if (left != null && !left.isBST) isBST = false;
        if (right != null && !right .isBST) isBST = false;
        if (left != null && left.max >= x.value) isBST = false;
        if (right != null && right.min <= x.value) isBST = false;
        return new Info(isBST, max, min);
    }
}