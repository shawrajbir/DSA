class Solution {
    public int divide(int dividend, int divisor) {
        // Special case: overflow condition
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // True if signs are different, meaning quotient is negative
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative values to prevent integer overflow
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        int quotient = 0;

        // Exponential search using left shifts (doubling)
        while (dividend <= divisor) {
            int currentDivisor = divisor;
            int count = 1;

            // Double the divisor until it would exceed dividend or cause 32-bit overflow
            // Note: currentDivisor >= -1073741824 prevents overflow when shifting left
            while (currentDivisor >= -1073741824 && dividend <= (currentDivisor << 1)) {
                currentDivisor <<= 1;
                count <<= 1;
            }

            dividend -= currentDivisor;
            quotient += count;
        }

        return negative ? -quotient : quotient;
    }
}