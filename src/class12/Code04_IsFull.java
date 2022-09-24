package class12;

/**
 * Author: shlstart
 * Create: 2022-09-14
 */
public class Code04_IsFull {
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int data) {
            value = data;
        }
    }
    //full binary tree 2^h -1 nodes
    //step 1 find height
    //step 2 count total nodes
    public static boolean isFull(Node head) {
        if (head == null) return true;
        Info1 all = process1(head);
        return (1 << all.height) - 1 == all.nodes;
    }

    public static class Info1 {
        int height;
        int nodes;
        public Info1(int h, int n) {
            height = h;
            nodes = n;
        }
    }
    public static Info1 process1(Node head) {
        if (head == null) return new Info1(0, 0);
        Info1 left = process1(head.left);
        Info1 right = process1(head.right);
        int height = Math.max(left.height, right.height) + 1;
        int nodes = left.nodes + right.nodes + 1;
        return new Info1(height, nodes);
    }
    public static class Info2 {
        boolean isFull;
        int height;
        public Info2(boolean f, int h) {
            isFull = f;
            height = h;
        }
    }

    public static Info2 process2(Node h) {
        if (h == null) return new Info2(true, 0);
        Info2 left = process2(h.left);
        Info2 right = process2(h.right);
        boolean isFull = left.isFull && right.isFull && left.height == right.height;
        int height = Math.max(left.height, right.height) + 1;
        return new Info2(isFull, height);
    }
}