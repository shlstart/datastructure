package class03;

/**
 * Author: shlstart
 * Create: 2022-09-01
 */
//target 2:       2 ->2->3->4->2->5
public class DeleteGivenValue {

    public static Node removeValue(Node head, int num) {
        while (head != null) {
            if (head.value != num) break;
            head = head.next;
        }

        //case 1 head == null
        //case 2 head != null
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                //skip this
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


}