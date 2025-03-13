package main.java;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_2534 {
    static final int UNUSED = -1, ENTER = 0, EXIT = 1;

    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] answer = new int[n];
        Queue<Integer>[] queues = IntStream.range(0, 2).mapToObj(i -> new ArrayDeque<Integer>()).toArray(Queue[]::new);
        int prev = UNUSED;
        int time = 0;
        int index = 0;
        while (index < n || !queues[ENTER].isEmpty() || !queues[EXIT].isEmpty()) {
            while (index < n && arrival[index] <= time) {
                queues[state[index]].offer(index);
                index++;
            }
            if (!queues[ENTER].isEmpty() && !queues[EXIT].isEmpty()) {
                if (prev == UNUSED || prev == EXIT) {
                    int person = queues[EXIT].poll();
                    answer[person] = time;
                    prev = EXIT;
                } else if (prev == ENTER) {
                    int person = queues[ENTER].poll();
                    answer[person] = time;
                    prev = ENTER;
                }
            } else if (!queues[ENTER].isEmpty()) {
                int person = queues[ENTER].poll();
                answer[person] = time;
                prev = ENTER;
            } else if (!queues[EXIT].isEmpty()) {
                int person = queues[EXIT].poll();
                answer[person] = time;
                prev = EXIT;
            } else prev = UNUSED;
            time++;
        }
        return answer;
    }
}
