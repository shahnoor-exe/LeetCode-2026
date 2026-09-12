class Solution {
    class I implements Comparable<I> {
        int s, e, id;
        long w;
        I(int s, int e, long w, int id) {
            this.s = s; this.e = e; this.w = w; this.id = id;
        }
        public int compareTo(I o) {
            return Integer.compare(this.s, o.s);
        }
    }
    class S {
        long w;
        int[] arr;
        S(long w, int[] arr) {
            this.w = w; this.arr = arr;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        I[] a = new I[n];
        for (int i = 0; i < n; i++) {
            a[i] = new I(intervals.get(i).get(0), intervals.get(i).get(1), intervals.get(i).get(2), i);
        }
        Arrays.sort(a);

        S[][] dp = new S[n + 1][5];
        for (int i = 0; i <= n; i++) dp[i][0] = new S(0, new int[0]);
        for (int k = 1; k <= 4; k++) dp[n][k] = new S(0, new int[0]);

        for (int i = n - 1; i >= 0; i--) {
            int nxt = bs(a, i + 1, n - 1, a[i].e);
            for (int k = 1; k <= 4; k++) {
                S skip = dp[i + 1][k];
                S tk = dp[nxt][k - 1];
                long tw = a[i].w + tk.w;

                if (tw > skip.w) {
                    dp[i][k] = new S(tw, ms(a[i].id, tk.arr));
                } else if (tw < skip.w) {
                    dp[i][k] = skip;
                } else {
                    int[] tArr = ms(a[i].id, tk.arr);
                    dp[i][k] = ls(tArr, skip.arr) ? new S(tw, tArr) : skip;
                }
            }
        }
        return dp[0][4].arr;
    }

    private int bs(I[] a, int l, int h, int t) {
        int res = a.length;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (a[m].s > t) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    private int[] ms(int id, int[] old) {
        int[] r = new int[old.length + 1];
        r[0] = id;
        for (int i = 0; i < old.length; i++) r[i + 1] = old[i];
        Arrays.sort(r);
        return r;
    }

    private boolean ls(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);
        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) return a[i] < b[i];
        }
        return a.length < b.length;
    }
}