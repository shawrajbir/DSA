class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        long oddCount = 0;
        long evenCount = 1; // Base case: prefix sum 0 is even
        long currentSum = 0;
        long totalOddSubarrays = 0;

        for (int num : arr) {
            currentSum += num;
            if (currentSum % 2 == 1) {
                totalOddSubarrays = (totalOddSubarrays + evenCount) % MOD;
                oddCount++;
            } else {
                totalOddSubarrays = (totalOddSubarrays + oddCount) % MOD;
                evenCount++;
            }
        }

        return (int) totalOddSubarrays;
    }
}