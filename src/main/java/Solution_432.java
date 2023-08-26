package main.java;

import java.util.*;

public class Solution_432 {
    static class AllOne {
        TreeMap<Integer, Set<String>> cntMap = new TreeMap<>();
        Map<String, Integer> strMap = new HashMap<>();

        public AllOne() {
        }

        public void inc(String key) {
            Integer oldCnt = strMap.get(key);
            int cnt;
            if (oldCnt == null) {
                cnt = 1;
                oldCnt = -1;
            } else cnt = oldCnt + 1;
            strMap.put(key, cnt);

            Set<String> set = cntMap.get(oldCnt);
            if (set != null) {
                set.remove(key);
                if (set.isEmpty()) cntMap.remove(oldCnt);
            }
            Set<String> newStr = cntMap.computeIfAbsent(cnt, k -> new HashSet<>());
            newStr.add(key);
        }

        public void dec(String key) {
            Integer oldCnt = strMap.get(key);
            int cnt;

            if (oldCnt != null) {
                cnt = oldCnt - 1;

                Set<String> set = cntMap.get(oldCnt);
                set.remove(key);
                if (set.isEmpty()) cntMap.remove(oldCnt);
                if (cnt == 0) strMap.remove(key);
                else {
                    Set<String> strSet = cntMap.computeIfAbsent(cnt, k -> new HashSet<>());
                    strSet.add(key);
                    strMap.put(key, cnt);
                }
            }
        }

        public String getMaxKey() {
            if (cntMap.isEmpty()) return "";
            Integer cnt = cntMap.lastKey();
            Set<String> set = cntMap.get(cnt);
            if (cnt == null) return "";
            return set.stream().findFirst().orElse("");

        }

        public String getMinKey() {
            if (cntMap.isEmpty()) return "";
            Integer cnt = cntMap.firstKey();
            Set<String> set = cntMap.get(cnt);
            if (cnt == null) return "";
            return set.stream().findFirst().orElse("");
        }
    }
}
