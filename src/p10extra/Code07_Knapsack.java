package p10extra;

/**
 * Author: shlstart
 * Create: 2022-09-20
 */
public class Code07_Knapsack {

    public static void main(String[] args) {

    }

    public static int process1(int[] weights, int[] values, int i , int alreadyWeight, int bag) {
        if (alreadyWeight > bag) return 0;
        if (i == weights.length) return 0;

        //dont pick current i
        int noPick = process1(weights, values, i + 1, alreadyWeight, bag);
        int currentWeight = alreadyWeight + weights[i];
        int pick = values[i] + process1(weights, values, i + 1, currentWeight, bag);
        return Math.max(noPick, pick);

    }
}