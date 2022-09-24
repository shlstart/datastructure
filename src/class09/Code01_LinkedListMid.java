package class09;

/**
 * Author: shlstart
 * Create: 2022-09-07
 */
public class Code01_LinkedListMid {
    public static class Node {
        int value;
        Node next;
        public Node(int v) {
            value = v;
        }
    }
    public static Node midOrUpMidNode(Node head) {
        //if 3 nodes, head is the upmid node
        //if more than 3, let slow = head, fast = head.next;
        if (head == null || head.next == null || head.next.next == null) return head;
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) return head;
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}