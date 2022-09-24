package class09;

import java.util.Stack;

/**
 * Author: shlstart
 * Create: 2022-09-07
 */
public class Code02_IsPalindromeList {
    public static class Node {
        int value;
        Node next;
        public Node(int data) {
            value = data;
        }
    }

    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node n2 = slow.next;
        slow.next = null;
        Node n1 = slow;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1; //n1 is new head
        n2 = head;// left first node
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        //reconnect list
        n1 = n3.next;
        n3.next = null;
        while (n1 != null ) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;

    }
}