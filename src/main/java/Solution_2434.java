package main.java;

public class Solution_2434 {
    public String robotWithString(String s) {
        int[] arr = new int[26];
        char[] sChar = s.toCharArray();
        for (char myChar : sChar) arr[myChar - 'a']++;
        StringBuilder t = new StringBuilder();
        StringBuilder p = new StringBuilder();
        int index = 0;
        for (int i = 0; i < 26; i++) {
            while (t.length() > 0 && t.charAt(t.length() - 1) <= i + 'a') {
                p.append(t.charAt(t.length() - 1));
                t.deleteCharAt(t.length() - 1);
            }
            while (arr[i] > 0) {
                if (sChar[index] == i + 'a') {
                    p.append(sChar[index]);
                    arr[i]--;
                } else {
                    t.append(sChar[index]);
                    arr[sChar[index] - 'a']--;
                }
                index++;
            }
        }
        p.append(t.reverse());
        return p.toString();
    }
}
