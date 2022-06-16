package main.java;

import java.util.Arrays;

public class Solution_2264 {
    public String largestGoodInteger(String num) {
        String[] diff = {"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};

        return Arrays.stream(diff)
                .filter(num::contains)
                .findFirst()
                .orElse("");
    }
}
