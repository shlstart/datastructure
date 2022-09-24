package class03;

/**
 * Author: shlstart
 * Create: 2022-09-01
 */
public class DoubleEndsQueueToStackAndQueue {

    public static class Node<T> {
        T value;
        Node<T> last;
        Node<T> next;
        public Node(T data) {
            value = data;
        }
    }

    public static class DoubleendsQueue<T> {

        Node<T> head;
        Node<T> tail;

        public void addFromHead(T value) {

            Node<T> cur = new Node<>(value);

            if (tail == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }

        }

        public void addFromBottom(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                cur.last = tail;
                tail = cur;
            }
        }

        public T popFromHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.last = null;
                cur.next = null;
            }
            return cur.value;

        }

        public T popFromBottom() {
            if (head == null) return null;
            Node<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;

        }

        public boolean isEmpty() {
            return head == null;
        }
    }

}