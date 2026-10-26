class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all numbers together.
        // Pairs cancel out (x ^ x = 0), leaving xorSum = a ^ b.
        long xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }

        // Step 2: Isolate the lowest set bit (rightmost 1-bit).
        // Using `long` prevents integer overflow if xorSum == Integer.MIN_VALUE (-2^31).
        long diffBit = xorSum & (-xorSum);

        // Step 3: Divide numbers into two groups based on the isolated bit.
        // 'a' and 'b' will fall into different groups; duplicates cancel within groups.
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}