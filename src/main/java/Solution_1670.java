package main.java;

import java.util.LinkedList;
import java.util.List;

public class Solution_1670 {
    static class FrontMiddleBackQueue {
        List<Integer> list = new LinkedList<>();

        public FrontMiddleBackQueue() {

        }

        public void pushFront(int val) {
            list.add(0, val);
        }

        public void pushMiddle(int val) {
            list.add(list.size() / 2, val);
        }

        public void pushBack(int val) {
            list.add(val);
        }

        public int popFront() {
            if (list.size() == 0) return -1;
            int res = list.get(0);
            list.remove(0);
            return res;
        }

        public int popMiddle() {
            if (list.size() == 0) return -1;
            int res = list.get((list.size() - 1) / 2);
            list.remove((list.size() - 1) / 2);
            return res;
        }

        public int popBack() {
            if (list.size() == 0) return -1;
            int res = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return res;
        }
    }
}
