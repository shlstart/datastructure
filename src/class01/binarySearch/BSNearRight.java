package class01.binarySearch;

/**
 * Author: shlstart
 * Create: 2022-08-31
 */
public class BSNearRight {

    //find x <= value most right
    public static int nearestIndex(int[] arr, int value) {
        int left = 0;
        int right = arr.length -1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= value) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}