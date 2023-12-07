package main.java;

import java.util.Iterator;

public class Solution_284 {
    static class PeekingIterator implements Iterator<Integer> {

        private final Iterator<Integer> iterator;
        private Integer cache = null;

        public PeekingIterator(Iterator<Integer> iter) {
            iterator = iter;
        }

        public Integer peek() {
            if (cache == null) cache = iterator.next();
            return cache;
        }

        @Override
        public Integer next() {
            if (cache == null) return iterator.next();
            Integer temp = cache;
            cache = null;
            return temp;
        }

        @Override
        public boolean hasNext() {
            return cache != null || iterator.hasNext();
        }
    }
}
