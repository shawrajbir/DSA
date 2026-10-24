class Solution {
    private static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // Find the overlap range
        String start = arriveAlice.compareTo(arriveBob) >= 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) <= 0 ? leaveAlice : leaveBob;

        // If Alice and Bob's intervals do not intersect
        if (start.compareTo(end) > 0) {
            return 0;
        }

        return toDayOfYear(end) - toDayOfYear(start) + 1;
    }

    private int toDayOfYear(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += DAYS[i];
        }
        return dayOfYear;
    }
}