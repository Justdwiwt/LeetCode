package main.java;

import java.util.*;
import java.util.stream.IntStream;

public class Solution_966 {
    private final Set<String> wordSet = new HashSet<>();
    private final Map<String, String> wordPatternMap = new HashMap<>();

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


    private String maskVowel(String word) {
        char[] letters = word.toCharArray();
        IntStream.range(0, letters.length).filter(i -> isVowel(letters[i])).forEach(i -> letters[i] = '*');
        return String.valueOf(letters);
    }

    private String search(String query) {
        if (wordSet.contains(query)) return query;
        query = query.toLowerCase();
        if (wordPatternMap.containsKey(query)) return wordPatternMap.get(query);
        query = maskVowel(query);
        return wordPatternMap.getOrDefault(query, "");
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Arrays.stream(wordlist).forEach(word -> {
            wordSet.add(word);
            String wordLC = word.toLowerCase();
            wordPatternMap.putIfAbsent(wordLC, word);
            wordPatternMap.putIfAbsent(maskVowel(wordLC), word);
        });
        IntStream.range(0, queries.length).forEach(i -> queries[i] = search(queries[i]));
        return queries;
    }
}
