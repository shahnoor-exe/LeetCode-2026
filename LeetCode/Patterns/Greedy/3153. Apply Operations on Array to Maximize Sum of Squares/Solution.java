class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] c = new int[32];
        for (int x : nums)
            for (int i = 0; i < 32; i++)
                if ((x & (1 << i)) != 0) c[i]++;
                
        long ans = 0, mod = 1000000007;
        while (k-- > 0) {
            long cur = 0;
            for (int i = 0; i < 32; i++)
                if (c[i] > 0) {
                    cur |= (1 << i);
                    c[i]--;
                }
            ans = (ans + cur * cur) % mod;
        }
        return (int) ans;
    }
}