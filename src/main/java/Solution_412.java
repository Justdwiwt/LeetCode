package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_412 {
    public List<String> fizzBuzz(int n) {
        List<String> li = new ArrayList<>();
        IntStream.rangeClosed(1, n).forEach(i -> {
            if (i % 3 == 0 && i % 5 == 0) li.add("FizzBuzz");
            else if (i % 3 == 0) li.add("Fizz");
            else if (i % 5 == 0) li.add("Buzz");
            else li.add(Integer.toString(i));
        });
        return li;
    }
}
