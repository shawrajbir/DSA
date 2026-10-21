class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // Check if already sorted
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        // If length is 2 and not sorted, no proper substring can fix it
        if (n == 2) return -1;
        
        char mn = 'z';
        char mx = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < mn) mn = c;
            if (c > mx) mx = c;
        }
        
        // 1 operation if the minimum is at the start or maximum is at the end
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }
        
        // Check if mn exists in proper prefix s[0 .. n - 2]
        boolean mnInPrefix = false;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == mn) {
                mnInPrefix = true;
                break;
            }
        }
        
        // Check if mx exists in proper suffix s[1 .. n - 1]
        boolean mxInSuffix = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == mx) {
                mxInSuffix = true;
                break;
            }
        }
        
        if (mnInPrefix || mxInSuffix) {
            return 2;
        }
        
        return 3;
    }
}