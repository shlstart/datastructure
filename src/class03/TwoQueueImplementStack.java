package class03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: shlstart
 * Create: 2022-09-01
 */
public class TwoQueueImplementStack {

    public static class TwoQueueStack<T> {
        Queue<T> queue;
        Queue<T> help;

        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T value) {
            queue.offer(value);
        }

        public T poll() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            return ans;
        }

        public T peeK() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            help.offer(ans);
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            return ans;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }


    }
}