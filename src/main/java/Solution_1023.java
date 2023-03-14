package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution_1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        return Arrays.stream(queries)
                .map(st -> Pattern.matches(pattern.replace("", "[a-z]*"), st))
                .collect(Collectors.toList());
    }
}
