package main.java;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = Arrays.stream(pieces)
                .collect(Collectors.toMap(piece -> piece[0], piece -> piece, (a, b) -> b));
        for (int i = 0; i < arr.length; ) {
            if (!map.containsKey(arr[i])) return false;
            int[] array = map.get(arr[i]);
            for (int j = 0; j < array.length; j++, i++)
                if (arr[i] != array[j]) return false;
        }
        return true;
    }
}
