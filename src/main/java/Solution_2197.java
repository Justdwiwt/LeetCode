package main.java;

import java.util.ArrayList;
import java.util.List;

public class Solution_2197 {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        list.add(nums[0]);
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            int x, gcd;
            int num = nums[i];
            while (idx >= 0 && (gcd = getGcd((x = list.get(idx)), num)) > 1) {
                num = (int) ((long) x * num / gcd);
                idx--;
            }
            if (++idx > list.size() - 1) list.add(num);
            else list.set(idx, num);
        }
        return list.subList(0, idx + 1);
    }

    private int getGcd(int x, int y) {
        while (y > 0) {
            int mod = x % y;
            x = y;
            y = mod;
        }
        return x;
    }
}
