package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1507 {
    private static final String[] monthName = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private static final Map<String, Integer> map;

    static {
        map = new HashMap<>();
        IntStream.range(0, monthName.length).forEach(i -> map.put(monthName[i], i + 1));
    }

    public String reformatDate(String date) {
        String[] split = date.split("\\s");
        String s1 = split[0];
        String s2 = s1.substring(0, s1.length() - 2);
        int day = Integer.parseInt(s2);
        int month = map.get(split[1]);
        return String.format("%s-%02d-%02d", split[2], month, day);
    }
}
