package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        HashMap<Integer, List<Integer>> map = IntStream.range(0, values.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> labels[i], HashMap::new, Collectors.mapping(i -> values[i], Collectors.toList())));
        List<Integer> all = new ArrayList<>();
        for (List<Integer> now : map.values()) {
            now.sort((o1, o2) -> o2 - o1);
            for (int i = 0; i < now.size() && i < useLimit; i++) all.add(now.get(i));
        }
        all.sort((o1, o2) -> o2 - o1);
        int res = 0;
        for (int i = 0; i < all.size() && i < numWanted; i++) res += all.get(i);
        return res;
    }
}
