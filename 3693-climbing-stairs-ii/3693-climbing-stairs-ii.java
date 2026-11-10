class Solution {
    public int climbStairs(int n, int[] costs) {
        // dp[j] stores the minimum cost to reach step j
        int[] dp = new int[n + 1];
        
        // Base case: starting at step 0 with cost = 0
        dp[0] = 0;
        
        for (int j = 1; j <= n; j++) {
            int minCost = Integer.MAX_VALUE;
            
            // Check previous reachable steps: j-1, j-2, j-3
            for (int k = 1; k <= 3; k++) {
                int i = j - k;
                if (i >= 0) {
                    // Cost formula: dp[i] + costs[j-1] + (j - i)^2
                    // Note: costs is 0-indexed in Java, so costs[j] is accessed via costs[j - 1]
                    int currentCost = dp[i] + costs[j - 1] + (j - i) * (j - i);
                    minCost = Math.min(minCost, currentCost);
                }
            }
            dp[j] = minCost;
        }
        
        return dp[n];
    }
}