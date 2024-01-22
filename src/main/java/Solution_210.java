package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        int[] degree = new int[numCourses];

        List<List<Integer>> edges = IntStream
                .range(0, numCourses)
                .<List<Integer>>mapToObj(i -> new ArrayList<>())
                .collect(Collectors.toCollection(() -> new ArrayList<>(numCourses)));

        IntStream.range(0, prerequisites.length).forEach(i -> {
            degree[prerequisites[i][0]]++;
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        });

        Queue<Integer> queue = IntStream
                .range(0, numCourses)
                .filter(i -> degree[i] == 0)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        int count = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            res.add(course);
            count++;
            edges.get(course).forEach(c -> {
                degree[c]--;
                if (degree[c] == 0) queue.add(c);
            });
        }

        if (count != numCourses) return new int[0];

        return IntStream
                .range(0, numCourses)
                .map(res::get)
                .toArray();
    }
}
