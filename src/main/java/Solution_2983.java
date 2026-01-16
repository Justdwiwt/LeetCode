package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2983 {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                boolean flag = true;
                for (int k = 0; k + 1 < sub.length(); k++)
                    if (sub.charAt(k) != sub.charAt(k + 1)) flag = false;
                if (flag)
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        int maxlen = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() >= 3 && maxlen < entry.getKey().length()) maxlen = entry.getKey().length();
        return maxlen == 0 ? -1 : maxlen;
    }
}
