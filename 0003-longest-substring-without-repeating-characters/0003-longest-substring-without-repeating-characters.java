class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] charIndex = new int[128];
        // Initialize all indices to -1
        java.util.Arrays.fill(charIndex, -1);
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            // If the character is repeating within the current window, move the left pointer
            if (charIndex[c] >= left) {
                left = charIndex[c] + 1;
            }
            // Update the last seen index of the character
            charIndex[c] = right;
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}