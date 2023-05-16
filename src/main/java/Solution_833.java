package main.java;

import java.util.stream.IntStream;

public class Solution_833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        int[] arr = new int[s.length()];
        IntStream.range(0, n).filter(i -> s.startsWith(sources[i], indices[i])).forEach(i -> arr[indices[i]] = i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 0) sb.append(s.charAt(i));
            else {
                sb.append(targets[arr[i] - 1]);
                i += (sources[arr[i] - 1].length() - 1);
            }
        return sb.toString();
    }
}
