class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); 
        backtrack(candidates, target, 0, new ArrayList<>(), res, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, int start, 
        List<Integer> current, List<List<Integer>> res, int sum) {        
        if (sum == target) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            backtrack(candidates, target, i + 1, current, res, sum + candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}