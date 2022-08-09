package main.java;

import java.util.LinkedList;

public class Solution_2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(flipper(answerKey, k, 'F'), flipper(answerKey, k, 'T'));
    }

    private int flipper(String answerKey, int k, char countLetter) {
        int max = 0;
        int cnt = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < answerKey.length(); i++) {
            char letter = answerKey.charAt(i);
            if (letter == countLetter) cnt++;
            else if (k > 0) {
                queue.add(i);
                k--;
                cnt++;
            } else {
                queue.add(i);
                max = Math.max(cnt, max);
                Integer firstEncountered = queue.removeFirst();
                cnt = i - firstEncountered;
            }
        }
        max = Math.max(cnt, max);
        return max;
    }
}
