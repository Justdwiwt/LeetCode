package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        IntStream.range(0, keyName.length).forEach(i -> {
            String[] time = keyTime[i].split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            List<Integer> list = map.getOrDefault(keyName[i], new ArrayList<>());
            list.add(h * 60 + m);
            map.put(keyName[i], list);
        });

        return map.entrySet().stream()
                .filter(x -> {
                    List<Integer> list = x.getValue();
                    list.sort(Integer::compareTo);
                    for (int i = 0; i < (list.size() - 2); i++) {
                        int t1 = list.get(i);
                        int t2 = list.get(i + 2);
                        if ((t2 - t1) <= 60) return true;
                    }
                    return false;
                })
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }
}
