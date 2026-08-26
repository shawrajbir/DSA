
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);

            boolean valid = true;
            boolean changed = false;

            for (char c : s.toCharArray()) {

                if (c == '3' || c == '4' || c == '7') {
                    valid = false;
                    break;
                }

                if (c == '2' || c == '5' || c == '6' || c == '9') {
                    changed = true;
                }
            }

            if (valid && changed) {
                count++;
            }
        }

        return count;
    }
}