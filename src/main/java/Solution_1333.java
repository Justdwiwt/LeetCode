package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Stream.of(restaurants)
                .filter(r -> (veganFriendly != 1 || r[2] == veganFriendly) && r[4] <= maxDistance && r[3] <= maxPrice)
                .sorted((r1, r2) -> r1[1] != r2[1] ? r2[1] - r1[1] : r2[0] - r1[0])
                .map(r -> r[0])
                .collect(Collectors.toList());
    }
}
