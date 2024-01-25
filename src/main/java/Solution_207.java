package main.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ind = new int[numCourses];

        List<List<Integer>> arr = IntStream
                .range(0, numCourses)
                .<List<Integer>>mapToObj(i -> new ArrayList<>())
                .collect(Collectors.toList());

        Arrays.stream(prerequisites).forEach(cp -> {
            ind[cp[0]]++;
            arr.get(cp[1]).add(cp[0]);
        });

        Queue<Integer> q = IntStream
                .range(0, numCourses)
                .filter(i -> ind[i] == 0)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        while (!q.isEmpty()) {
            int pre = q.poll();
            numCourses--;

            arr
                    .get(pre)
                    .stream()
                    .mapToInt(cur -> cur)
                    .filter(cur -> --ind[cur] == 0)
                    .forEach(q::add);
        }

        return numCourses == 0;
    }
}
