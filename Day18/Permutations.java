/*
Question Link:
https://leetcode.com/problems/permutations/

Question:
Return all possible permutations of the given array.
*/

class Solution {

    /*
    Fix one position at a time.

    Swap every remaining element
    into current position.

    Backtrack by swapping again
    to restore original array.
    */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, res, nums);
        return res;
    }

    public static void helper(int index, List<List<Integer>> res, int[] nums) {

        if(index == nums.length) {

            List<Integer> list = new ArrayList<>();

            for(int num : nums) {
                list.add(num);
            }

            res.add(list);
            return;
        }

        for(int i = index; i < nums.length; i++) {

            swap(i, index, nums);

            helper(index + 1, res, nums);

            swap(i, index, nums);
        }
    }

    public static void swap(int i, int index, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}