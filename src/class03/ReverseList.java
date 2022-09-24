package class03;

import java.util.ArrayList;

/**
 * Author: shlstart
 * Create: 2022-09-01
 */
public class ReverseList {


    public static void main(String[] args) {



    }

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = pre.next;
            head = next;
        }
        return pre;
    }

    public static DoubleNode revereDoubleLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = pre.next;
            head = next;
        }
        return pre;
    }

    public static Node testReverseLinkedList(Node head) {
        if (head == null) return null;

        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        for (int i = 1; i < list.size(); i++) {
            list.get(i).next = list.get(i -1);
        }
        return list.get(list.size() -1);
    }

    public static DoubleNode testReverseDoubleLinkedList(DoubleNode head) {
        if (head == null) return null;

        ArrayList<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {

            DoubleNode cur = list.get(i);
            cur.last = null;
            cur.next = pre;
            pre.last = cur;
            pre = cur;
        }
        return list.get(list.size() -1);
    }
}