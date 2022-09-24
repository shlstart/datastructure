package class03;

import java.util.Stack;

/**
 * Author: shlstart
 * Create: 2022-09-01
 */
public class TwoStacksImplementQueue {

    public static class TwoStacksQueue {
        Stack<Integer> stackPush;
        Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        private void pushToPop() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
        public void add(int pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }

        public int poll() {
           if (stackPop.isEmpty() && stackPush.isEmpty()) {
               throw new RuntimeException("queue is empty");
           }
           pushToPop();
           return stackPop.pop();
        }

        public int peek() {
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            pushToPop();
            return stackPop.peek();

        }
    }
}