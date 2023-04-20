package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution_911 {
    static class TopVotedCandidate {
        Map<Integer, Integer> cntMap = new HashMap<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            int maxPersonId = -1;
            for (int i = 0; i < persons.length; i++) {
                int cnt = cntMap.getOrDefault(persons[i], 0) + 1;
                cntMap.put(persons[i], cnt);
                int maxCnt = cntMap.getOrDefault(maxPersonId, 0);
                if (cnt >= maxCnt) maxPersonId = persons[i];
                tm.put(times[i], maxPersonId);
            }
        }

        public int q(int t) {
            return tm.floorEntry(t).getValue();
        }
    }
}
