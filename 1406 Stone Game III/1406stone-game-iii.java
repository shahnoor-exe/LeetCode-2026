class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] x = new Integer[n];
        int y = z(stoneValue, 0, x);
        if (y > 0) return "Alice";
        if (y < 0) return "Bob";
        return "Tie";
    }private int z(int[] stones, int i, Integer[] x) {
        if (i >= stones.length) return 0;
        if (x[i] != null) return x[i];
        int m = Integer.MIN_VALUE;
        int s = 0;
        for (int k = 0; k < 3 && i + k < stones.length; k++) {
            s += stones[i + k];
            int a = z(stones, i + k + 1, x);
            m = Math.max(m, s - a);
        }return x[i] = m;
    }
}