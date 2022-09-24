package class16;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Author: shlstart
 * Create: 2022-09-15
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

}