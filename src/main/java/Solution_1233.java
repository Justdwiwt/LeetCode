package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_1233 {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = Arrays.stream(folder).collect(Collectors.toMap(s -> s, String::length, (a, b) -> b));
        for (String s : folder) {
            int i = s.length() - 1;
            boolean flag = true;
            for (; i > 1; i--)
                if (s.charAt(i) == '/')
                    if (map.get(s.substring(0, i)) != null) flag = false;
            if (flag) res.add(s);
        }
        return res;
    }
}
