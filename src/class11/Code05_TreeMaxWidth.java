package class11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Author: shlstart
 * Create: 2022-09-09
 */
public class Code05_TreeMaxWidth {
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int data) {
            value = data;
        }
    }
    public static int maxWidthUseMap(Node head) {
        if (head == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Map<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLeveNodes = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }

            if (curNodeLevel == curLevel) {
                curLeveNodes++;
            } else {
                max = Math.max(max, curLeveNodes);
                curLevel++;
                curLeveNodes = 1;
            }
        }
        max = Math.max(max, curLeveNodes);
        return max;
    }

    public static int maxWidthNoMap(Node head) {
        if (head == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;
        Node nextEnd = null;
        int max = 0;
        int curLeveNodes = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLeveNodes++;
            if (cur == curEnd) {
                max = Math.max(max, curLeveNodes);
                curLeveNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
}