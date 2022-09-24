package p10extra;

import java.util.Stack;

/**
 * Author: shlstart
 * Create: 2022-09-20
 */
public class Code04_ReverseStackUseRecursion {
    //need two stack to revere element -> 1, 2, 3, ---> 3, 2, 1
    //Stack A holds all original elements, pop each element from stackA to stackB
    //stackB holds 3, 2, 1
    public static void reverse(Stack<Integer> stack) {

        if (stack.isEmpty()) return;
        int i = f(stack);
        reverse(stack);
        stack.push(i);

    }

    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) return result;
        else {
            int last = f(stack);
            stack.push(result);
            return last;
        }

    }
    public static void reverse2(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int i = f(stack);
        reverse2(stack);
        stack.push(i);
    }

    //get last element in stack
    public static int f2(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) return result;
        else {
            int last = f2(stack);
            stack.push(result);
            return last;
        }

    }
}