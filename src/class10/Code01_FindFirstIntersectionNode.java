package class10;

/**
 * Author: shlstart
 * Create: 2022-09-08
 */
public class Code01_FindFirstIntersectionNode {
    public static class Node {
        int value;
        Node next;
        public Node(int val) {
            value = val;
        }
    }
    //find first entry node of loop, if no loop return null
    //if no loop return null
    //if there is loop find entry node
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow == fast
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //compare last node address, last1 == last2, they must intersect, last1 != last2 not intersect
        if (cur1 != cur2) return null;
        //find longest list
        cur1 = n > 0? head1: head2;
        cur2 = cur1 == head1? head2: head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0? head1: head2;
            cur2 = cur1 == head1? head2: head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else { // case1 or case3, two loops are independent or two loops have same loops but at difference entry points
            cur1 = loop1.next;
            //goes one round different find loop2 then, they are separate loops
            while (cur1 != loop1) {
                if (cur1 == loop2) return loop1;
                cur1 = cur1.next;
            }
            return null;// separate loops

        }
    }

    public static Node getIntersection(Node head1, Node head2) {

        if (head1 == null || head2 == null) return null;
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) return noLoop(head1, head2);
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;


    }
}