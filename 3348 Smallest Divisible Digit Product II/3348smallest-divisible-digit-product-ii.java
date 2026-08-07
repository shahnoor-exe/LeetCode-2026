class Solution {
    public String smallestNumber(String num, long t) {
        int[] req = new int[10];
        for (int p : new int[]{2, 3, 5, 7}) while (t % p == 0) { req[p]++; t /= p; }
        if (t > 1) return "-1";
        int n = num.length(), z = num.indexOf('0'), maxP = (z == -1) ? n : z;
        int[][] pref = new int[n + 1][10];
        pref[0] = req.clone();
        for (int i = 0; i < maxP; i++) pref[i + 1] = reduce(pref[i], num.charAt(i) - '0');
        if (maxP == n && isDone(pref[n])) return num;
        for (int i = maxP; i >= 0; i--) {
            for (int d = (i < n ? num.charAt(i) - '0' + 1 : 1); d <= 9; d++) {
                String suf = buildSuffix(reduce(pref[i], d));
                if (suf.length() <= n - 1 - i) {
                    return num.substring(0, i) + d + "1".repeat((n - 1 - i) - suf.length()) + suf;
                }
            }
        }String minSuf = buildSuffix(req);
        int targetLen = Math.max(n + 1, minSuf.length());
        return "1".repeat(targetLen - minSuf.length()) + minSuf;
    }private int[] reduce(int[] c, int d) {
        int[] next = c.clone();
        for (int p : new int[]{2, 3, 5, 7}) {
            while (d > 1 && d % p == 0) { next[p] = Math.max(0, next[p] - 1); d /= p; }
        }return next;
    }private boolean isDone(int[] c) { return Arrays.stream(c).allMatch(v -> v == 0); }
    private String buildSuffix(int[] c) {
        int c2 = c[2], c3 = c[3], c5 = c[5], c7 = c[7];
        int d9 = c3 / 2, d8 = c2 / 3, d7 = c7, d6 = (c2 % 3 > 0 && c3 % 2 > 0) ? 1 : 0;
        c2 -= d8 * 3 + d6; c3 -= d9 * 2 + d6;
        int d5 = c5, d4 = c2 / 2, d3 = c3 % 2, d2 = c2 % 2;
        return Stream.of(new int[][]{{2, d2}, {3, d3}, {4, d4}, {5, d5}, {6, d6}, {7, d7}, {8, d8}, {9, d9}})
                .map(p -> String.valueOf(p[0]).repeat(p[1]))
                .collect(Collectors.joining());
    }
}