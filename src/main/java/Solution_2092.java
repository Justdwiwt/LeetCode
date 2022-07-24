package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2092 {
    private int[] unionFind;

    private int find(int pos) {
        return unionFind[pos] == pos ? pos : (unionFind[pos] = find(unionFind[pos]));
    }

    private void union(int pos1, int pos2) {
        unionFind[find(pos1)] = unionFind[find(pos2)];
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        Arrays.stream(meetings).filter(meeting -> meeting[2] != 0).forEach(pq::offer);
        unionFind = new int[n];
        IntStream.range(1, n).forEach(i -> unionFind[i] = i);
        unionFind[firstPerson] = 0;
        while (!pq.isEmpty()) {
            List<int[]> list = new ArrayList<>();
            list.add(pq.poll());
            while (!pq.isEmpty() && list.get(0)[2] == pq.peek()[2])
                list.add(pq.poll());
            list.forEach(m -> union(m[0], m[1]));
            list.forEach(m -> {
                if (find(m[0]) != find(firstPerson)) unionFind[m[0]] = m[0];
                if (find(m[1]) != find(firstPerson)) unionFind[m[1]] = m[1];
            });
        }

        return IntStream.range(0, n)
                .filter(i -> find(i) == find(firstPerson))
                .boxed()
                .collect(Collectors.toList());
    }
}
