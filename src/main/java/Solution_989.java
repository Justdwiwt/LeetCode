package main.java;

import java.util.LinkedList;
import java.util.List;

public class Solution_989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = A.length - 1;
        while (i >= 0 || K > 0) {
            if (i >= 0) K += A[i--];
            res.addFirst(K % 10);
            K /= 10;
        }
        return res;
    }
}
