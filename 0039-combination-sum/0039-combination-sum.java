class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, target, new ArrayList<>(), candidates, result);
        return result;
    }

    private void backtrack(int start, int target, List<Integer> current, int[] candidates, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // Pass 'i' instead of 'i + 1' because the same number can be reused
            backtrack(i, target - candidates[i], current, candidates, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
