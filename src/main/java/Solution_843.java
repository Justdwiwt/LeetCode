package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_843 {
    interface Master {
        default int guess(String word) {
            return 0;
        }
    }

    public void findSecretWord(String[] wordlist, Master master) {
        if (wordlist == null || wordlist.length == 0) return;
        List<String> list = new ArrayList<>(Arrays.asList(wordlist));
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int idx = r.nextInt(list.size());
            String randomPick = list.get(idx);
            int match = master.guess(randomPick);
            list = list.stream().filter(s -> getMatch(s, randomPick) == match).collect(Collectors.toList());
        }
    }

    private int getMatch(String s, String pick) {
        if (s == null || s.length() == 0 || pick == null || pick.length() == 0) return 0;
        return (int) IntStream.range(0, Math.min(s.length(), pick.length()))
                .filter(i -> s.charAt(i) == pick.charAt(i))
                .count();
    }
}
