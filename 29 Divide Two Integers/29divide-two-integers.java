class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int a = -Math.abs(dividend);
        int b = -Math.abs(divisor);
        boolean negative = (dividend > 0) != (divisor > 0);

        int quotient = 0;
        while (a <= b) {
            int temp = b, multiple = 1;
            while (a <= (temp << 1) && (temp << 1) < 0) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}