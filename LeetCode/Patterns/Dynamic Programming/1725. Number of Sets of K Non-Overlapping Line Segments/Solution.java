class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        int totalPoints = n + k - 1;
        int pointsToPick = 2 * k;
        if (pointsToPick > totalPoints) {
            return 0;
        }
        long numerator = 1;
        long denominator = 1;
        for (int i = 1; i <= pointsToPick; i++) {
            numerator = (numerator * (totalPoints - i + 1)) % MOD;
            denominator = (denominator * i) % MOD;
        }
        long result = (numerator * modInverse(denominator, MOD)) % MOD;
        return (int) result;
    }
    private long modInverse(long base, int mod) {
        return power(base, mod - 2, mod);
    }
    private long power(long base, int exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}