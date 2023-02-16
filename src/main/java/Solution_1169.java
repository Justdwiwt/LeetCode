package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1169 {
    public List<String> invalidTransactions(String[] transactions) {
        String[][] st = Arrays.stream(transactions).map(transaction -> transaction.split(",")).toArray(String[][]::new);
        List<String> res = new ArrayList<>();
        for (String[] strings : st) {
            String tt = Arrays.toString(strings);
            tt = tt.substring(1, tt.length() - 1);
            tt = tt.replace(" ", "");
            if (Integer.parseInt(strings[2]) > 1000) {
                res.add(tt);
                continue;
            }
            if (Arrays.stream(st).anyMatch(t -> (Math.abs(Integer.parseInt(strings[1]) - Integer.parseInt(t[1])) <= 60 && strings[0].equals(t[0]) && !strings[3].equals(t[3]))))
                res.add(tt);
        }
        return res;
    }
}
