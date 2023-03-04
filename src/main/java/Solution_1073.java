package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<>();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int cur = 0;
        while (i >= 0 || j >= 0 || cur != 0) {
            int digit = cur;
            if (i >= 0) digit += arr1[i];
            if (j >= 0) digit += arr2[j];
            i--;
            j--;

            cur = 0;
            if (digit > 1) {
                digit -= 2;
                cur -= 1;
            }
            if (digit < 0) {
                digit += 2;
                cur += 1;
            }
            res.add(digit);
        }
        while (res.size() > 1 && res.get(res.size() - 1) == 0) res.remove(res.size() - 1);
        Collections.reverse(res);
        return res.stream().mapToInt(o -> o).toArray();
    }
}
