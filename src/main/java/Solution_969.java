package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int idx = 0;
            for (int j = 0; j < N - i; j++)
                if (arr[j] >= arr[idx]) idx = j;
            reverse(arr, idx);
            res.add(idx + 1);
            reverse(arr, N - i - 1);
            res.add(N - i);
        }
        return res;
    }

    void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i <= j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
