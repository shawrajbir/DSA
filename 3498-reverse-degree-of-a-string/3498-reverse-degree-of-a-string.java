class Solution {
    public int reverseDegree(String s) {
        int totalDegree = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int revAlphabetIndex = 'z' - c + 1;
            int stringIndex = i + 1;
            totalDegree += revAlphabetIndex * stringIndex;
        }
        return totalDegree;
    }
}
