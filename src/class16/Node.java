package class16;

import java.util.ArrayList;

/**
 * Author: shlstart
 * Create: 2022-09-15
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<Edge>();
    }

    public static void main(String[] args) {
        int a = (1<<3) - 1;
        System.out.println(a);
        int result = '3' - '0';
        System.out.println(result);

        char k = '1';
        char b = k;
        System.out.println((char)k);

    }

}