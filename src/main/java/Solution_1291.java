package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        String s = "123456789";
        for (int i = 1; i <= 9; i++)
            for (int j = 0; j + i <= s.length(); j++) {
                int num = Integer.parseInt(s.substring(j, j + i));
                if (num > high) break;
                else if (num >= low) list.add(num);
            }
        return list;
    }
}
