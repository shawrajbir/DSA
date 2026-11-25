import java.util.*;

class Solution {
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;
    private static final long BASE1 = 1315423911L;
    private static final long BASE2 = 2654435761L;

    private long[] pref1, pref2, pow1, pow2;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        pref1 = new long[n + 1];
        pref2 = new long[n + 1];
        pow1 = new long[n + 1];
        pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        for (int i = 0; i < n; i++) {
            // Add 1 to nums[i] to ensure non-zero values
            long val = nums[i] + 1L;
            pref1[i + 1] = (pref1[i] * BASE1 + val) % MOD1;
            pref2[i + 1] = (pref2[i] * BASE2 + val) % MOD2;
            pow1[i + 1] = (pow1[i] * BASE1) % MOD1;
            pow2[i + 1] = (pow2[i] * BASE2) % MOD2;
        }

        int low = 1, high = n, ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUniqueSubarray(n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUniqueSubarray(int n, int len) {
        int count = n - len + 1;
        Map<Long, Integer> freq = new HashMap<>(count * 2);

        for (int i = 0; i < count; i++) {
            long hash = getSubarrayHash(i, i + len);
            freq.put(hash, freq.getOrDefault(hash, 0) + 1);
        }

        for (int f : freq.values()) {
            if (f == 1) return true;
        }
        return false;
    }

    private long getSubarrayHash(int l, int r) {
        long h1 = (pref1[r] - (pref1[l] * pow1[r - l]) % MOD1 + MOD1) % MOD1;
        long h2 = (pref2[r] - (pref2[l] * pow2[r - l]) % MOD2 + MOD2) % MOD2;
        return (h1 << 32) | h2;
    }
}