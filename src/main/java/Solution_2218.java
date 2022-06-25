package main.java;

import java.util.List;
import java.util.stream.IntStream;

public class Solution_2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] arr = new int[k + 1];
        int sumN = 0;
        for (List<Integer> pile : piles) {
            int n = pile.size();
            IntStream.range(1, n).forEach(i -> pile.set(i, pile.get(i) + pile.get(i - 1)));
            sumN = Math.min(sumN + n, k);
            for (int j = sumN; j > 0; --j)
                for (int w = 0; w < Math.min(n, j); ++w)
                    arr[j] = Math.max(arr[j], arr[j - w - 1] + pile.get(w));
        }
        return arr[k];
    }
}
