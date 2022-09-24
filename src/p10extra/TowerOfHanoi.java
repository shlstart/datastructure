package p10extra;

/**
 * Author: shlstart
 * Create: 2022-09-19
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        hanoi(3);


    }
    public static void hanoi(int n) {
        if (n > 0) func(n, "left", "right", "middle");
    }
    static void func(int i, String start, String end, String other) {
        if (i == 1) {
            System.out.println("Move 1 from " + start + " to " + end);
        } else {
            func(i - 1, start, other, end);
            System.out.println("Move " + i + " from " + start + " to " + end);
            func(i - 1, other, end , start);
        }

    }
}