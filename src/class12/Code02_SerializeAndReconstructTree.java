package class12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: shlstart
 * Create: 2022-09-14
 */
public class Code02_SerializeAndReconstructTree {
    public static class Node {
        int value;
        Node left;
        Node right;
        public Node(int data) {
            value = data;
        }
    }
    public static Queue<String> preSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }
    public static void pres(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
            return;
        }
        ans.add(String.valueOf(head.value));
        pres(head.left, ans);
        pres(head.right, ans);
    }

    public static Node buildByPreQueue(Queue<String> prelist) {
        if (prelist == null || prelist.size() == 0) {
            return null;
        }
        return preb(prelist);
    }
    public static Node preb(Queue<String> prelist) {
        String value = prelist.poll();
        if (value == null) return null;
        Node head = new Node(Integer.valueOf(value));
        head.left = preb(prelist);
        head.right = preb(prelist);
        return head;
    }

    public static Queue<String> leveSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
            return ans;
        }
        //level traversal queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                ans.add(String.valueOf(head.left.value));
                queue.add(head.left);
            } else {
                queue.add(null);
            }
            if (head.right != null) {
                queue.add(head.right);
            } else {
                queue.add(null);
            }
        }
        return ans;
    }

    public static Node buildByLevelQueue(Queue<String> levelList) {
        if (levelList == null || levelList.size() == 0) return null;
        Node head = generateNode(levelList.poll());
        Queue<Node> queue = new LinkedList<>();
        if (head == null) return head;
        queue.add(head);
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;

    }

    private static Node generateNode(String val) {
        if (val == null) return null;
        return new Node(Integer.valueOf(val));
    }
}