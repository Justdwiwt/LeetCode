package main.java;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1409 {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> linkedList = IntStream.rangeClosed(1, m)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        IntStream.range(0, queries.length).forEach(i -> {
            int query = queries[i];
            int temp = linkedList.indexOf(query);
            linkedList.remove(temp);
            linkedList.addFirst(query);
            queries[i] = temp;
        });

        return queries;
    }
}
