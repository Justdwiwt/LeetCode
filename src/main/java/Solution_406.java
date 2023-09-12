package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_406 {
    public int[][] reconstructQueue(int[][] people) {
        if (0 == people.length || 0 == people[0].length) return new int[0][0];
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        Arrays.stream(people).forEach(i -> list.add(i[1], i));
        return list.toArray(new int[list.size()][]);
    }
}
