package class11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: shlstart
 * Create: 2022-09-09
 */
public class Code01_LevelTraversalBT {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void level(Node head) {
        if (head == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
}