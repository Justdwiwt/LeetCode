package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]> t = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                t.add(new int[]{arr[i], arr[j]});
        t.sort((a, b) -> Integer.compare(a[0] * b[1], a[1] * b[0]));
        return t.get(k - 1);
    }
}
