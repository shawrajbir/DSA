class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for (int x : nums) {
            if (x > max) {
                max = x;
            }
            sum += x;
        }

        return max * nums.length - sum;
    }
}