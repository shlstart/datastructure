package class09;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: shlstart
 * Create: 2022-09-07
 */
public class Code04_CopyListWithRandom {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyRandomList2(Node head) {
        Node cur = head;
        if (head == null) return head;
        Node next = null;
        //1 -> 2 -> 3
        //1-> 1' ->2 ->2' -> 3 -> 3'
        while (cur != null) {
            next = cur.next;
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = next;
        }

        //random
        cur = head;
        Node copy = null;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random != null ? cur.random.next: null;
            cur = next;
        }

        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.next = next != null ? next.next: null;
            cur = next;
        }
        return res;
    }
}