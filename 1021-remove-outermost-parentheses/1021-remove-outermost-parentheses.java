class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If balance > 0, this '(' is not an outermost parenthesis
                if (balance > 0) {
                    sb.append(c);
                }
                balance++;
            } else {
                balance--;
                // If balance > 0 after decrementing, this ')' is not an outermost parenthesis
                if (balance > 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}