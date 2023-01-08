package main.java;

import java.util.*;

public class Solution_1348 {
    static class TweetCounts {

        private final Map<String, TreeMap<Integer, Integer>> tweetMap;

        public TweetCounts() {
            tweetMap = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time) {
            TreeMap<Integer, Integer> treeMap = tweetMap.computeIfAbsent(tweetName, v -> new TreeMap<>());
            treeMap.put(time, treeMap.getOrDefault(time, 0) + 1);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            List<Integer> res = new ArrayList<>();
            int interval = "minute".equals(freq) ? 60 : "hour".equals(freq) ? 60 * 60 : 60 * 60 * 24;
            TreeMap<Integer, Integer> userTweets = tweetMap.get(tweetName);
            for (int time = startTime; time <= endTime; time += interval) {
                int end = Math.min(time + interval, endTime + 1);
                Map.Entry<Integer, Integer> entry = userTweets.ceilingEntry(time);
                int count = 0;
                while (entry != null && entry.getKey() < end) {
                    count += entry.getValue();
                    entry = userTweets.higherEntry(entry.getKey());
                }
                res.add(count);
            }
            return res;
        }
    }
}
