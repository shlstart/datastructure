package class03;

import java.util.Stack;

/**
 * Author: shlstart
 * Create: 2022-09-01
 */
public class GetMinStack {

    public static class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (stackMin.isEmpty()) {
                stackMin.push(newNum);
            } else if (newNum <= stackMin.peek()) {
                stackMin.push(newNum);
            } else {
                int newMin = stackMin.peek();
                stackMin.push(newMin);
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("statck is empty");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return this.stackMin.peek();
        }
    }
}