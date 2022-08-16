package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1993 {
    static class LockingTree {
        int n;
        int[] locked;
        List<Integer>[] children;
        int[] parent;

        public LockingTree(int[] parent) {
            n = parent.length;
            locked = new int[n];
            children = new ArrayList[n];
            IntStream.range(0, n).forEach(i -> children[i] = new ArrayList<>());
            IntStream.range(0, parent.length).filter(i -> parent[i] != -1).forEach(i -> children[parent[i]].add(i));
            this.parent = parent;
        }

        public boolean lock(int num, int user) {
            if (locked[num] == 0) {
                locked[num] = user;
                return true;
            }
            return false;
        }

        public boolean unlock(int num, int user) {
            if (locked[num] == user) {
                locked[num] = 0;
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            if (locked[num] == 0 && this.checkUnlock(num) && this.checkLock(num)) {
                locked[num] = user;
                this.unlock(num);
                return true;
            }
            return false;
        }

        private void unlock(int num) {
            List<Integer> cur = children[num];
            for (int child : cur) {
                if (this.locked[child] != 0)
                    this.locked[child] = 0;
                this.unlock(child);
            }

        }

        private boolean checkLock(int num) {
            List<Integer> cur = children[num];
            for (int child : cur) {
                if (this.locked[child] != 0) return true;
                if (this.checkLock(child)) return true;
            }
            return false;
        }

        private boolean checkUnlock(int num) {
            while (parent[num] != -1 && this.locked[parent[num]] == 0)
                num = this.parent[num];
            return parent[num] == -1;
        }
    }

}
