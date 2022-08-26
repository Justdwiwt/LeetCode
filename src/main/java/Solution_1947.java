package main.java;

import java.util.stream.IntStream;

public class Solution_1947 {
    int maxScore;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] assigned = new boolean[students.length];
        assignMentors(assigned, students, mentors, 0, 0);
        return maxScore;
    }

    private void assignMentors(boolean[] assigned, int[][] students, int[][] mentors, int studentNo, int score) {
        if (studentNo >= students.length) {
            maxScore = Math.max(maxScore, score);
            return;
        }
        for (int i = 0; i < mentors.length; i++)
            if (!assigned[i]) {
                assigned[i] = true;
                assignMentors(assigned, students, mentors, studentNo + 1, score + score(students[studentNo], mentors[i]));
                assigned[i] = false;
            }
    }

    private int score(int[] a, int[] b) {
        return (int) IntStream.range(0, b.length)
                .filter(i -> a[i] == b[i])
                .count();
    }
}
