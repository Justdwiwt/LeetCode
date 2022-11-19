package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        return IntStream.rangeClosed(rounds[0], rounds[0] > rounds[rounds.length - 1] ? rounds[rounds.length - 1] + n : rounds[rounds.length - 1])
                .map(e -> e > n ? e - n : e)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }
}
