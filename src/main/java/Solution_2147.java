package main.java;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_2147 {
    public int numberOfWays(String corridor) {
        final int M = 1000000007;

        ArrayList<Integer> arr = IntStream.range(0, corridor.length())
                .filter(i -> corridor.charAt(i) == 'S')
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        if (arr.isEmpty() || (arr.size() & 1) != 0) return 0;
        BigInteger res = new BigInteger("1");
        for (int i = 2; i < arr.size(); i += 2)
            res = res.multiply(new BigInteger(arr.get(i) - arr.get(i - 1) + ""));
        return res.remainder(new BigInteger(M + "")).intValue();
    }
}
