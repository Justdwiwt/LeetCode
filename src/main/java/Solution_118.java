package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        return Stream.iterate(new ArrayList<>(Collections.singletonList(1)), row -> {
                    int size = row.size() + 1;
                    return IntStream.range(0, size)
                            .mapToObj(i -> (i == 0 || i == size - 1) ? 1 : row.get(i - 1) + row.get(i))
                            .collect(Collectors.toCollection(ArrayList::new));
                })
                .limit(numRows)
                .collect(Collectors.toList());
    }
}
