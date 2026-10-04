class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0; // Minimum possible open '(' count
        int cmax = 0; // Maximum possible open '(' count

        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmin--;
                cmax--;
            } else if (c == '*') {
                // '*' can be ')', empty "", or '('
                cmin--; // if '*' acts as ')'
                cmax++; // if '*' acts as '('
            }

            // More ')' than available '(' and '*'
            if (cmax < 0) {
                return false;
            }

            // cmin cannot be negative (we cannot have negative open brackets)
            if (cmin < 0) {
                cmin = 0;
            }
        }

        // Valid if the minimum open count can reach 0
        return cmin == 0;
    }
}