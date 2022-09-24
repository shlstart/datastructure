package class01.sort;

/**
 * Author: shlstart
 * Create: 2022-08-31
 */
public class BubbleSort {

    /**
     * 0 - N -1
     * 0 - N -2
     * 0 - N -3
     * 0 - 1
     * @param arr
     */

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

    }

    public static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr [j];
        arr[j] = temp;
    }
}