package main.java;

public class Solution_2526 {
    static class DataStream {
        int count, pre, value, k;

        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
            count = 0;
            pre = -1;
        }

        public boolean consec(int num) {
            count = num == pre ? count + 1 : 1;
            pre = num;
            return num == value && count >= k;
        }
    }
}
