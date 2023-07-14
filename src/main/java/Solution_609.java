package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (String s : paths) {
            String[] str = s.split(" ");
            for (int i = 1; i < str.length; i++) {
                String key = str[i].substring(str[i].indexOf("(") + 1, str[i].indexOf(")"));
                if (!map.containsKey(key)) {
                    map.put(key, idx++);
                    list.add(new ArrayList<>());
                }
                list.get(map.get(key)).add(str[0] + "/" + str[i].substring(0, str[i].indexOf("(")));
            }
        }
        for (int i = list.size() - 1; i >= 0; i--)
            if (list.get(i).size() < 2) list.remove(i);
        return list;
    }
}
