class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(candidates,target,0, new ArrayList<>(),res,0);
        return res;
    }
    public void backtrack(int[] candidates,int target,int start,List<Integer>current,List<List<Integer>> res,int sum){
        if(sum==target){
            res.add(new ArrayList<>(current));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
                current.add(candidates[i]);
                backtrack(candidates, target, i, current, res, sum + candidates[i]);
                current.remove(current.size() - 1);
            
        }
    }
}