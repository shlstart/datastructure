package class01.binarySearch;

import java.util.*;

/**
 * Author: shlstart
 * Create: 2022-08-31
 */
public class BSNearLeft {

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        Collection<List<String>> values = map.values();
        ArrayList<List<String>> lists = new ArrayList<>(values);
        double ceil = Math.ceil(2.5);
        System.out.println(ceil);
    }

    public static int nearestIndex(int[] arr, int value) {
        int left = 0;
        int right = arr.length -1;
        int index = -1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (arr[mid] >= value) {
                index = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}