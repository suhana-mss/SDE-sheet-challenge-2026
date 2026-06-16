/*
Question Link:
https://leetcode.com/problems/subsets-ii/

Question:
Return all possible subsets.
Duplicate subsets are not allowed.
*/

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        helper(0, nums, ans, new ArrayList<>());

        return ans;
    }

    /*
    Sort first so duplicates become adjacent.

    Skip duplicate starts at the same recursion level.

    Add current subset before exploring deeper.
    */

    public void helper(int index, int[] nums, List<List<Integer>> ans, List<Integer> list) {

        ans.add(new ArrayList<>(list));

        for(int i = index; i < nums.length; i++) {

            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);

            helper(i + 1, nums, ans, list);

            list.remove(list.size() - 1);
        }
    }
}