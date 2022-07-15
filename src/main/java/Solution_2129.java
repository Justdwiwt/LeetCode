package main.java;

import java.util.stream.IntStream;

public class Solution_2129 {
    public String capitalizeTitle(String title) {
        String[] arr = title.toLowerCase().split(" ");
        IntStream.range(0, arr.length).filter(i -> arr[i].length() > 2).forEach(i -> {
            char[] ch = arr[i].toCharArray();
            ch[0] ^= 32;
            arr[i] = new String(ch);
        });
        return String.join(" ", arr);
    }
}
