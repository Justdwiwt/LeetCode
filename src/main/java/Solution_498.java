package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, index = 0;
        int[] res = new int[m * n];
        List<List<Integer>> nl = new ArrayList<>();
        for (int i = 0; i < m + n - 1; i++) {
            int r = i < m ? i : m - 1;
            int c = i < m ? 0 : i - m + 1;
            List<Integer> nums = new ArrayList<>();
            while (r >= 0 && c < n) nums.add(mat[r--][c++]);
            nl.add(nums);
        }
        IntStream.range(0, m + n - 1).filter(i -> (i & 1) != 0).mapToObj(nl::get).forEach(Collections::reverse);
        for (List<Integer> nums : nl)
            for (int num : nums) res[index++] = num;
        return res;
    }
}
