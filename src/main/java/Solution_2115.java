package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> ind = new HashMap<>();
        IntStream.range(0, recipes.length).forEach(i -> {
            for (String item : ingredients.get(i)) {
                map.computeIfAbsent(item, o -> new ArrayList<>()).add(recipes[i]);
            }
            ind.merge(recipes[i], ingredients.get(i).size(), Integer::sum);
        });
        Queue<String> queue = new ArrayDeque<>();
        Arrays.stream(supplies).forEach(queue::offer);
        while (!queue.isEmpty())
            map.getOrDefault(queue.poll(), new ArrayList<>()).stream().filter(next -> ind.merge(next, -1, Integer::sum) == 0).forEach(next -> {
                res.add(next);
                queue.offer(next);
            });
        return res;
    }
}
