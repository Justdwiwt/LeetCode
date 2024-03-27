package main.java;

import java.util.*;

public class Solution_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!wordDict.contains(endWord)) return res;
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> begin = new HashSet<>(), end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        if (search(wordDict, begin, end, map)) buildPath(res, map, endWord, beginWord, new LinkedList<>());
        return res;
    }

    private boolean search(Set<String> wordDict, Set<String> begin, Set<String> end, Map<String, Set<String>> map) {
        if (begin.isEmpty()) return false;
        wordDict.removeAll(begin);
        boolean isMeet = false;
        Set<String> next = new HashSet<>();
        for (String word : begin) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    if (ch == temp) continue;
                    String str = String.valueOf(chars);
                    if (wordDict.contains(str)) {
                        next.add(str);
                        if (end.contains(str)) isMeet = true;
                        map.computeIfAbsent(str, k -> new HashSet<>()).add(word);
                    }
                }
                chars[i] = temp;
            }
        }
        return isMeet || search(wordDict, next, end, map);
    }

    private void buildPath(List<List<String>> res, Map<String, Set<String>> map, String begin, String end, LinkedList<String> list) {
        list.addFirst(begin);
        if (begin.equals(end)) res.add(new ArrayList<>(list));
        if (map.containsKey(begin)) map.get(begin).forEach(next -> buildPath(res, map, next, end, list));
        list.removeFirst();
    }
}
