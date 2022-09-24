package p10extra;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Author: shlstart
 * Create: 2022-09-22
 */
public class SlidingWindow {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.peek());


    }
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) return null;
        int index = 0;
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        for (int i = 0; i < arr.length; i++) {
            //if arr[i] >= value with window from end, remove it until arr[o] is not longer greater
            //we can safetly remove them
            while (!qmax.isEmpty() && arr[qmax.getLast()] <= arr[i]) {
                qmax.removeLast();
            }
            qmax.addLast(i);
            //check length of window to shrink
            //first index at 2, i = 6, w = 3
            //first is expired
            if (qmax.peekFirst() == i - w) {
                qmax.removeFirst();
            }
            //window is formed, there is w elements in window,
            //why -1 because i starts from 0 index
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
                System.out.println("hello");
            }
        }
        return res;
    }
}