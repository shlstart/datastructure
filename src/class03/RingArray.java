package class03;

/**
 * Author: shlstart
 * Create: 2022-09-01
 */
public class RingArray {

    public static class MyQueue {

        int[] arr;
        int pushi;
        int polli;
        int size;
        int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) throw new RuntimeException("queue is full");
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (size == 0) throw new RuntimeException("queue is empty");
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int nextIndex(int i) {

            if (i == limit -1) {
                i = 0;
            } else {
                i = i + 1;
            }
            return i;

        }

    }
}