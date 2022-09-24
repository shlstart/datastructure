package class09;

/**
 * Author: shlstart
 * Create: 2022-09-07
 */
public class Code03_SmallerEqualBigger {
    public static class Node {
        int value;
        Node next;
        public Node(int data) {
            value = data;
        }
    }

    public static Node listPartition1(Node head, int pivot) {
        if (head == null) return head;
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        //put every nodes into arr
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }

        arrPartition(nodeArr, pivot);
        //reconnect all the nodes
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i -1].next = nodeArr[i];
        }
        return nodeArr[0];
    }
    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            }else {
                swap(nodeArr, --big, index);
            }
        }
    }
    public static void swap(Node[] nodeArr, int a, int b) {
        Node temp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = temp;
    }

    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        Node next = head;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }

        //connect all 3 parts
        if (sT != null) {
            sT.next = eH;
            //eH can be null or not
            eT = eT == null? sT: eT;
        }

        if (eT != null) {
            eT.next = mH;
        }
        return sH != null? sH: (eH != null ? eH: mH);
    }
}