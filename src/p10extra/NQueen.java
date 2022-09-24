package p10extra;

/**
 * Author: shlstart
 * Create: 2022-09-20
 */
public class NQueen {

    public static void main(String[] args) {

    }

    public static int nqueen(int n) {
        //i is row, records[i] is col
        int[] records = new int[n];

        return process1(0, records, n);
    }
    static int process1(int i, int[] records, int n) {
        if (i == n) return 1; // found an answer
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(records, i, j)) {
                records[i] = j;
                res += process1(i + 1, records, n);
            }
        }
        return res;
    }
    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            //col check
            if (j == record[k]) return false;
            //check slop (r1 - r2) / (c1 - c2)
            if (Math.abs(record[k] - j) == Math.abs(i - k)) return false;
        }
        return true;
    }
}