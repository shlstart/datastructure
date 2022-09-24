package class01.sort;

/**
 * Author: shlstart
 * Create: 2022-08-31
 */
public class SelectionSort {
    public static void main(String[] args) {

    }


    /**
     * 0 - N -1 find smallest one and put in index 0
     * 1 - N -1 find smallest one and put in index 1
     *
     * @param arr
     */
    public static void selSort(int[] arr) {

        if (arr == null || arr.length == 0) return;

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}