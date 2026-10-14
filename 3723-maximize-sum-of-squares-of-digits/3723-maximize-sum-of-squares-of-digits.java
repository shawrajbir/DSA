class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 1 || (long) num * 9 < sum) {
            return "";
        }

        int count9 = sum / 9;
        int rem = sum % 9;
        int count0 = num - count9 - (rem > 0 ? 1 : 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count9; i++) {
            sb.append('9');
        }
        if (rem > 0) {
            sb.append(rem);
        }
        for (int i = 0; i < count0; i++) {
            sb.append('0');
        }

        return sb.toString();
    }
}
