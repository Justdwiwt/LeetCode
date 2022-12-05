package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        int k = 0;
        for (String name : names)
            if (!map.containsKey(name)) {
                res[k++] = name;
                map.put(name, 0);
            } else {
                int idx = map.get(name) + 1;
                String s = name + "(" + idx + ")";
                while (map.containsKey(s)) {
                    idx++;
                    s = name + "(" + idx + ")";
                }
                map.put(name, idx);
                map.put(s, 0);
                res[k++] = s;
            }
        return res;
    }
}
