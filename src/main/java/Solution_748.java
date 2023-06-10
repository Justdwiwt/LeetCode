package main.java;

import java.util.TreeSet;

public class Solution_748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] arr = licensePlate.replaceAll("\\d| ", "").toLowerCase().toCharArray();
        TreeSet<String> set = new TreeSet<>((o1, o2) -> o1.length() != o2.length() ? o1.length() - o2.length() : 1);
        for (String word : words) {
            boolean flag = true;
            String copyWord = word;
            for (char c : arr)
                if (copyWord.indexOf(c) < 0) flag = false;
                else copyWord = copyWord.replaceFirst(c + "", "#");
            if (flag) set.add(word);
        }
        return set.first();
    }
}
