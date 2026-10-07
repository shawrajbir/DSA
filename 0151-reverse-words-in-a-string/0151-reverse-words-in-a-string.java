class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Skip trailing or intermediate spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;

            // Find the start of the current word
            int j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Append word and a space separator
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(s.substring(i + 1, j + 1));
        }

        return sb.toString();
    }
}
