import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int left = 0;
        int currentSum = 0;
        int ans = Integer.MAX_VALUE;
        int minSoFar = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            // Shrink the window if currentSum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }

            // Valid subarray found
            if (currentSum == target) {
                int curLen = right - left + 1;

                // Check if there is a valid subarray to the left that does not overlap
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, curLen + minLen[left - 1]);
                }

                minSoFar = Math.min(minSoFar, curLen);
            }

            // Update DP array for the current index
            minLen[right] = minSoFar;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
