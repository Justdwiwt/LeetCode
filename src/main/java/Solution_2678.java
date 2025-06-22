package main.java;

import java.util.Arrays;

public class Solution_2678 {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details)
                .map(detail -> detail.substring(11, 13))
                .filter(str -> Integer.parseInt(str) > 60)
                .count();
    }
}
