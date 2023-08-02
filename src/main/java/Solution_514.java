package main.java;

import java.util.HashMap;

public class Solution_514 {
    HashMap<String, Integer> memory = new HashMap<>();

    public int findRotateSteps(String ring, String key) {
        if (key == null || "".equals(key)) return 0;
        String tag = ring + "_" + key;
        if (memory.containsKey(tag)) return memory.get(tag);
        int len = ring.length();
        int step = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++)
            if (ring.charAt(i) == key.charAt(0)) {
                String newRing = ring.substring(i) + ring.substring(0, i);
                String newKey = key.substring(1);
                step = Math.min(step, Math.min(i, len - i) + 1 + findRotateSteps(newRing, newKey));
            }
        memory.put(tag, step);
        return step;
    }
}
