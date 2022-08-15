package main.java;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution_1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        if (properties == null || properties.length == 0) return 0;

        AtomicInteger currMaxX = new AtomicInteger();
        AtomicInteger currMaxY = new AtomicInteger();

        return (int) Arrays.stream(properties)
                .sorted((o1, o2) -> {
                    if (o1[0] == o2[0]) return o1[1] - o2[1];
                    else return o2[0] - o1[0];
                })
                .peek(p -> {
                    if (currMaxY.get() < p[1]) {
                        currMaxY.set(p[1]);
                        currMaxX.set(p[0]);
                    }
                })
                .filter(p -> currMaxX.get() > p[0] && currMaxY.get() > p[1])
                .count();
    }
}
