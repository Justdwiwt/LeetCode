package main.java;

import java.util.Arrays;

public class Solution_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        Arrays.stream(students).forEach(student -> cnt[student]++);
        for (int sandwich : sandwiches)
            if (cnt[sandwich] > 0) cnt[sandwich]--;
            else break;
        return cnt[0] + cnt[1];
    }
}
