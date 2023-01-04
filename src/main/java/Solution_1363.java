package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1363 {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        List<Queue<Integer>> list = IntStream.range(0, 3)
                .<Queue<Integer>>mapToObj(i -> new LinkedList<>())
                .collect(Collectors.toList());

        int sum = 0;
        for (int d : digits) {
            sum += d;
            list.get(d % 3).add(d);
        }
        if (sum % 3 != 0)
            if (!list.get(sum % 3).isEmpty()) list.get(sum % 3).poll();
            else for (int i = 0; i < 2; i++) list.get(sum % 3 ^ 3).poll();

        List<Integer> newList = IntStream.range(0, 3)
                .flatMap(i -> list.get(i).stream().mapToInt(x -> x))
                .boxed()
                .sorted(Comparator.comparing(x -> x))
                .collect(Collectors.toList());

        StringBuilder res = new StringBuilder();
        newList.forEach(i -> res.insert(0, i));
        return res.toString().startsWith("0") ? "0" : res.toString();
    }
}
