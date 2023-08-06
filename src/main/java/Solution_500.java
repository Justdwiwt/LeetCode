package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_500 {
    public String[] findWords(String[] words) {
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int n1 = 0, n2 = 0, n3 = 0, leng = word.length();
            for (int i = 0; i < leng; i++)
                if (s1.contains(String.valueOf(word.charAt(i)))) n1++;
                else if (s2.contains(String.valueOf(word.charAt(i)))) n2++;
                else n3++;
            if (n1 == leng || n2 == leng || n3 == leng) list.add(word);
        }
        return list.toArray(new String[0]);
    }
}
