package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution_649 {
    public String predictPartyVictory(String senate) {
        int i = senate.length();
        Queue<Character> senates = new LinkedList<>();
        IntStream.range(0, i).mapToObj(senate::charAt).forEach(senates::offer);
        int y = 0;
        while (Math.abs(y) < (senates.size() + 1) / 2) {
            if (senates.poll() == 'R') {
                if (y >= 0) senates.offer('R');
                y++;
            } else {
                if (y <= 0) senates.offer('D');
                y--;
            }
        }
        return y > 0 ? "Radiant" : "Dire";
    }
}
