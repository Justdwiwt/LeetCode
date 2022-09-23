package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        int t;
        HashMap<String, String> m;
        StringBuilder sb = new StringBuilder();
        m = knowledge.stream().collect(Collectors.toMap(list -> list.get(0), list -> list.get(1), (a, b) -> b, HashMap::new));
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                t = i;
                while (s.charAt(i) != ')') i++;
                String ss = s.substring(t + 1, i);
                if (m.get(ss) != null) sb.append(m.get(ss));
                else sb.append('?');
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
