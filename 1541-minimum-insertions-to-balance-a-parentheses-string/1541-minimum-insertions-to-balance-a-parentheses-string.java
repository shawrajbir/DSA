class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openCount = 0; // Tracks unmatched '('
        int i = 0;
        int n = s.length();

        while (i < n) {
            char c = s.charAt(i);

            if (c == '(') {
                openCount++;
                i++;
            } else {
                // Check if this ')' is followed by another ')' to make "))"
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2; // Matched a pair "))"
                } else {
                    insertions++; // Need to insert 1 ')' to make "))"
                    i++;
                }

                // Match with an existing '(' or insert one
                if (openCount > 0) {
                    openCount--;
                } else {
                    insertions++; // Need to insert 1 '(' before "))"
                }
            }
        }

        // Each remaining '(' needs "))" (2 closing brackets each)
        insertions += openCount * 2;

        return insertions;
    }
}