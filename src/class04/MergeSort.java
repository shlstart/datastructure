package class04;

/**
 * Author: shlstart
 * Create: 2022-09-02
 */
public class MergeSort {

    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) return;

        process(arr, 0, arr.length -1);
    }
//    public static void process(int[] arr, int L, int R) {
//        if (L == R) return;
//        int mid = L + (R - L) / 2;
//        process(arr, L, mid);
//        process(arr, mid + 1, R);
//        merge(arr, L, mid, R);
//    }

//    public static void merge(int[] arr, int L, int mid, int R) {
//        int[] help = new int[R - L + 1];
//        int p1 = L;
//        int p2 = mid + 1;
//        int i = 0;
//        while (p1 <= mid && p2 <= R) {
//            help[i++] = arr[p1] <= arr[p1]? arr[p1++]: arr[p2++];
//        }
//
//        while (p1 <= mid) {
//            help[i++] = arr[p1++];
//        }
//        while (p2 <= R) {
//            help[i++] = arr[p2++];
//        }
//
//        for (int k = 0; k < help.length; k++) {
//            arr[L + k] = help[k];
//        }
//    }

//    //non recursive
//    public static void mergeSort2(int[] arr) {
//        if (arr == null || arr.length < 2) return;
//
//        int N = arr.length;
//        int mergeSize = 1;
//        while (mergeSize < N) {
//            //find L, mid , R
//            int L = 0;
//            while (L < N) {
//                //skip this group, since it has not enough for mid index
//                if (mergeSize >= N - L) break;
//                int mid = L + mergeSize - 1;
//                int R = mid + Math.min(mergeSize, N - mid - 1);
//                merge(arr, L, mid, R);
//                L = R = 1;
//            }
//            if (mergeSize > N / 2) break;
//            mergeSize <<= 1;
//        }
//    }

    public static void process(int[] arr, int L, int R) {

        if (L == R) return;

        int mid = L + (R - L ) / 2;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int p1 = L;
        int p2 = mid + 1;
        int[] help = new int[R - L + 1];
        int i = 0;

        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2]? arr[p1++]: arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (int k = 0; k < help.length; k++) {
            arr[L + k] = help[k];
        }
    }

    public static void mergeSort2(int[] arr) {

        if (arr == null || arr.length < 2) return;

        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                //not enough element to form one size
                if (mergeSize >= N - L) break;
                int mid = L + mergeSize -1;
                int R = mid + Math.min(mergeSize, N - mid - 1);
                merge(arr, L, mid, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) break;
            mergeSize <<= 1;
        }

    }
}