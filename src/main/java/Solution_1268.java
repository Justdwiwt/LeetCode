package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new LinkedList<>();
        IntStream.rangeClosed(1, searchWord.length()).mapToObj(i -> searchWord.substring(0, i)).forEach(prefix -> {
            List<String> collector = Arrays.stream(products).filter(product -> product.startsWith(prefix)).limit(3).collect(Collectors.toCollection(LinkedList::new));
            res.add(collector);
        });
        return res;
    }
}
