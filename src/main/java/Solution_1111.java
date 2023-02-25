package main.java;

public class Solution_1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray())
            res[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        return res;
    }
}
