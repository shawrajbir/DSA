import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1_000_000;
        
        // Precompute proper divisors for every possible substring length
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 2; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d * d <= len; d++) {
                if (len % d == 0) {
                    if (d < len) divisors[len].add(d);
                    if (d != len / d && (len / d) < len) {
                        divisors[len].add(len / d);
                    }
                }
            }
        }
        
        // cost[i][j] = min changes to make s[i..j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], INF);
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                for (int d : divisors[len]) {
                    cost[i][j] = Math.min(cost[i][j], getCost(s, i, j, d));
                }
            }
        }
        
        // dp[i][parts] = min changes to split s[0..i-1] into 'parts' semi-palindromes
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;
        
        for (int parts = 1; parts <= k; parts++) {
            // Each part needs at least length 2
            for (int i = parts * 2; i <= n; i++) {
                for (int p = (parts - 1) * 2; p <= i - 2; p++) {
                    if (dp[p][parts - 1] != INF) {
                        dp[i][parts] = Math.min(dp[i][parts], dp[p][parts - 1] + cost[p][i - 1]);
                    }
                }
            }
        }
        
        return dp[n][k];
    }
    
    private int getCost(String s, int start, int end, int d) {
        int changes = 0;
        int len = end - start + 1;
        for (int rem = 0; rem < d; rem++) {
            int left = start + rem;
            int right = start + len - d + rem;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    changes++;
                }
                left += d;
                right -= d;
            }
        }
        return changes;
    }
}