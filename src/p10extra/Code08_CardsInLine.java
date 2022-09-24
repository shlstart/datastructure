package p10extra;

/**
 * Author: shlstart
 * Create: 2022-09-19
 */
public class Code08_CardsInLine {

    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        return Math.max(f(arr, 0, arr.length -1), s(arr, 0, arr.length - 1));
    }
    public static int f(int[] arr, int i, int j) {
        if (i == j) return arr[i];
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j -1));
    }
    //second player's turn pick first
    public static int s(int[] arr, int i, int j) {
        //when there is only one value left, second player pick first, left no more value for
        //second player to pick
        if (i == j) return 0;
        //first player can only pick min, because max already pick up by second player
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }
}