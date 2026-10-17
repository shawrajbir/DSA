import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Element structure: [digitSum, value, originalIndex]
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = getDigitSum(nums[i]);
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }

        // Sort by digit sum ascending, tie-breaker: numerical value ascending
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Find cycles in the permutation
        boolean[] visited = new boolean[n];
        int cycles = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i) {
                continue;
            }

            // Traverse the cycle
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = arr[curr][2];
            }
            cycles++;
        }

        // Alternatively, using the formula: total elements in non-trivial cycles - number of non-trivial cycles
        // Or directly:
        int swaps = 0;
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i) {
                continue;
            }

            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = arr[curr][2];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    private int getDigitSum(int val) {
        int sum = 0;
        while (val > 0) {
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }
}