package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_2288 {
    public String discountPrices(String sentence, int discount) {
        String[] split = sentence.split(" ");
        double M = discount / 100.0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() <= 1) continue;
            if (split[i].startsWith("$") && isDigit(split[i].substring(1))) {
                String sub = split[i].substring(1);
                double money = Double.parseDouble(sub);
                money = money - (money * M);
                split[i] = "$" + String.format("%.2f", money);
            }
        }
        StringBuilder res = new StringBuilder();
        Arrays.stream(split).map(s -> s + " ").forEach(res::append);
        return res.substring(0, res.length() - 1);
    }

    private boolean isDigit(String s) {
        if (s.length() == 0) return false;
        return IntStream.range(0, s.length()).allMatch(i -> Character.isDigit(s.charAt(i)));
    }
}
