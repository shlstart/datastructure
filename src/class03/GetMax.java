package class03;

/**
 * Author: shlstart
 * Create: 2022-09-02
 */
public class GetMax {
    public static void main(String[] args) {

    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) return arr[L];
        int mid = L + (R - L) / 2;
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}