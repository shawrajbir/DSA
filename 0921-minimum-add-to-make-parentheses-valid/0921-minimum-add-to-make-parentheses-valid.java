class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;       // Unmatched '(' seen so far
        int insertions = 0; // '(' needed for unmatched ')'

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    insertions++;
                }
            }
        }

        return insertions + open;
    }
}