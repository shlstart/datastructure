package class12;

/**
 * Author: shlstart
 * Create: 2022-09-13
 */
public class Code03_IsBalanced {
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int v) {
            value = v;
        }
    }
    public static class Info {
        boolean isBalanced;
        int height;
        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    public static Info process(Node head) {
        if (head == null) return new Info(true, 0);
        Info left = process(head.left);
        Info right = process(head.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = true;
        if (!left.isBalanced) isBalanced = false;
        if (!right.isBalanced) isBalanced = false;
        if (Math.abs(left.height - right.height) > 1) isBalanced = false;
        return new Info(isBalanced, height);
    }

    public static boolean isBalanced1(Node head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head, ans);
        return ans[0];
    }
    public static int process1(Node head, boolean[] ans) {
        //cut branch when ans[0] is false, return -1 no need for further examination
        if (!ans[0] || head == null) return -1;
        int left = process1(head.left, ans);
        int right = process1(head.right, ans);
        if (Math.abs(left - right) > 1) ans[0] = false;
        return Math.max(left, right) + 1;
    }
}