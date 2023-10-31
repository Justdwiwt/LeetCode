package main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution_341 {
    public static class NestedIterator implements Iterator<Integer> {

        private final List<Integer> list = new ArrayList<>();
        private int index;

        private void add(List<NestedInteger> nestedList) {
            nestedList.forEach(nestedInteger -> {
                if (nestedInteger.isInteger()) list.add(nestedInteger.getInteger());
                else add(nestedInteger.getList());
            });
        }

        public NestedIterator(List<NestedInteger> nestedList) {
            add(nestedList);
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }
    }
}
