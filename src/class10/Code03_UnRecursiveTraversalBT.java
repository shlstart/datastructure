package class10;

import java.util.Stack;

/**
 * Author: shlstart
 * Create: 2022-09-09
 */
public class Code03_UnRecursiveTraversalBT {
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int v) {
            value = v;
        }
    }
    public static void pre(Node head) {
        if (head == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    public static void in(Node cur) {
        Stack<Node> stack = new Stack<>();
        //exist stack isEmpty and cur == null
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    public static void pos1(Node head) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null) {
                s1.push(head.left);
            }
            if (head.right != null) {
                s1.push(head.right);
            }
        }
        //left right head
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().value);
        }
    }

}