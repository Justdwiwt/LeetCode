package main.java;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Solution_2553 {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            String form = "" + num;
            IntStream.range(0, form.length()).mapToObj(i -> form.charAt(i) - '0').forEach(list::add);
        }
        return list.stream().mapToInt(integer -> integer).toArray();
    }
}
