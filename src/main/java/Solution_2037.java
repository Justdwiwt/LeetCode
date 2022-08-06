package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        return IntStream.range(0, students.length)
                .map(i -> Math.abs(students[i] - seats[i]))
                .sum();
    }
}
