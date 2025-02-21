package main.java;

import java.util.*;

public class Solution_2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> i[1] != j[1] ? j[1] - i[1] : i[0] - j[0]);

        Set<String> positive_feedbackSet = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative_feedbackSet = new HashSet<>(Arrays.asList(negative_feedback));

        for (int i = 0; i < report.length; i++) {
            String[] str = report[i].split(" ");
            int score = 0;
            for (String s : str)
                if (positive_feedbackSet.contains(s)) score += 3;
                else if (negative_feedbackSet.contains(s)) score -= 1;
            pq.offer(new int[]{student_id[i], score});
        }

        while (!pq.isEmpty() && k-- > 0) list.add(pq.poll()[0]);
        return list;
    }
}
