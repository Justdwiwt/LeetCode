package main.java;

public class Solution_2286 {
    static class BookMyShow {
        int n, m;
        int[] min;
        long[] sum;

        public BookMyShow(int n, int m) {
            this.n = n;
            this.m = m;
            min = new int[n * 4];
            sum = new long[n * 4];
        }

        public int[] gather(int k, int maxRow) {
            int i = index(1, 1, n, maxRow + 1, m - k);
            if (i == 0) return new int[]{};
            int seats = (int) querySum(1, 1, n, i, i);
            add(1, 1, n, i, k);
            return new int[]{i - 1, seats};
        }

        public boolean scatter(int k, int maxRow) {
            if ((long) (maxRow + 1) * m - querySum(1, 1, n, 1, maxRow + 1) < k) return false;
            for (int i = index(1, 1, n, maxRow + 1, m - 1); ; ++i) {
                int left_seats = m - (int) querySum(1, 1, n, i, i);
                if (k <= left_seats) {
                    add(1, 1, n, i, k);
                    return true;
                }
                k -= left_seats;
                add(1, 1, n, i, left_seats);
            }
        }

        void add(int o, int l, int r, int idx, int val) {
            if (l == r) {
                min[o] += val;
                sum[o] += val;
                return;
            }
            int m = (l + r) >>> 1;
            if (idx <= m) add(o * 2, l, m, idx, val);
            else add(o * 2 + 1, m + 1, r, idx, val);
            min[o] = Math.min(min[o * 2], min[o * 2 + 1]);
            sum[o] = sum[o * 2] + sum[o * 2 + 1];
        }

        long querySum(int o, int l, int r, int L, int R) {
            if (L <= l && r <= R) return sum[o];
            long sum = 0L;
            int m = (l + r) >>> 1;
            if (L <= m) sum += querySum(o * 2, l, m, L, R);
            if (R > m) sum += querySum(o * 2 + 1, m + 1, r, L, R);
            return sum;
        }

        int index(int o, int l, int r, int R, int val) {
            if (min[o] > val) return 0;
            if (l == r) return l;
            int m = (l + r) >>> 1;
            if (min[o * 2] <= val) return index(o * 2, l, m, R, val);
            if (m < R) return index(o * 2 + 1, m + 1, r, R, val);
            return 0;
        }
    }
}
