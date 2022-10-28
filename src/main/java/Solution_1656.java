package main.java;

import java.util.LinkedList;
import java.util.List;

public class Solution_1656 {
    static class OrderedStream {

        String[] strs;

        int ptr = 1;

        public OrderedStream(int n) {
            strs = new String[n + 2];
        }

        public List<String> insert(int idKey, String value) {
            strs[idKey] = value;
            List<String> res = new LinkedList<>();
            while (ptr < strs.length && strs[ptr] != null) {
                res.add(strs[ptr]);
                ++ptr;
            }
            return res;
        }
    }
}
