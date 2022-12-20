package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); ++i) {
            List<Integer> cur = nums.get(i);
            for (int j = 0; j < cur.size(); ++j)
                list.add(new int[]{cur.get(j), i, j});
        }
        list.sort((o1, o2) -> o1[1] + o1[2] - o2[1] - o2[2] == 0 ? (o1[2] - o2[2]) : o1[1] + o1[2] - o2[1] - o2[2]);
        return list.stream().mapToInt(ints -> ints[0]).toArray();
    }
}
