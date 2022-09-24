package class11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: shlstart
 * Create: 2022-09-09
 */
public class Code02_SerializeAndReconstructTree {
    public static class Node{
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
        } else {
            ans.add(String.valueOf(head.value));
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }
    public static Node buildPreQueue(Queue<String> prelist) {
        if (prelist == null || prelist.size() == 0) return null;
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
}