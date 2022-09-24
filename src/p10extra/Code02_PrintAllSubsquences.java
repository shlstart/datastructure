package p10extra;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: shlstart
 * Create: 2022-09-19
 */
public class Code02_PrintAllSubsquences {
    public static void main(String[] args) {
        char a = 49;
        System.out.println(a);
//        process(new char[]{'a','b','c'}, 0);

        List<String> list = new ArrayList<>();
        list.add("ab");
        list.add(null);
        list.add("cd");

        list.sort(null);
        System.out.println(list);

    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }

        process(chs, i + 1);
        char temp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);
        chs[i] = temp;
    }

    //permutation
    static List<String> result = new ArrayList<>();
    public static List<String> permutation(String str) {
        if (str == null || str.length() == 0) return result;
        char[] chs = str.toCharArray();
        processPermutation(chs, 0);
        result.sort(null);
        return result;
    }

    //with repeated characters
    public static void processPermutation(char[] chs, int i) {
        if (i == chs.length) {
            result.add(String.valueOf(chs));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < chs.length; j++) {
            if (!visit[chs[j] - 'a']) {
                visit[chs[j] - 'a'] = true;
                swap(chs, i, j);
                processPermutation(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }
    static void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }





}