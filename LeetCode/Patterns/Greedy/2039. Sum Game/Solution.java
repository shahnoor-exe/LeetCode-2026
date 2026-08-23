class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;
        int sumDiff = 0;
        int qDiff = 0;
        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                qDiff++;
            } else {
                sumDiff += c - '0';
            }
        }
        for (int i = half; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                qDiff--;
            } else {
                sumDiff -= c - '0';
            }
        }
        return !(qDiff % 2 == 0 && (2 * sumDiff + 9 * qDiff == 0));
    }
}