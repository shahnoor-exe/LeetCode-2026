class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length, ans = 0;
        int[] s = nums.clone();
        Arrays.sort(s);
        
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            boolean ok = true;
            for (int i = 0; i < n && ok; i += k) {
                int d = 0, idx = -1;
                for (int j = 0; j < k - 1; j++)
                    if (nums[i + j] > nums[i + j + 1]) { d++; idx = j; }
                
                if (d > 1 || (d == 1 && nums[i + k - 1] > nums[i])) ok = false;
                else {
                    int o = d == 0 ? 0 : idx + 1;
                    for (int j = 0; j < k; j++)
                        if (nums[i + (o + j) % k] != s[i + j]) { ok = false; break; }
                }
            }
            if (ok) ans += k;
        }
        return ans;
    }
}