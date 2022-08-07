package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer, Set<Integer>> numToArray = new HashMap<>();
        populateMap(nums1, numToArray, 1);
        populateMap(nums2, numToArray, 2);
        populateMap(nums3, numToArray, 3);

        return numToArray.keySet()
                .stream()
                .filter(n -> numToArray.get(n).size() > 1)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void populateMap(int[] nums, Map<Integer, Set<Integer>> freqMap, int id) {
        Arrays.stream(nums).forEach(n -> freqMap.computeIfAbsent(n, k -> new HashSet<>()).add(id));
    }
}
