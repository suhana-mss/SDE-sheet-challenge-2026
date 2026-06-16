/*
Question Link:
https://www.geeksforgeeks.org/problems/subset-sums2234/1

Question:
Return sum of every possible subset.
*/

class Solution {

    /*
    For every element:

    Take it
    or

    Skip it.

    Carry running sum through recursion.

    When index becomes invalid,
    store the final subset sum.
    */

    public ArrayList<Integer> subsetSums(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        helper(arr, arr.length - 1, ans, 0);

        return ans;
    }

    public void helper(int[] arr, int index, ArrayList<Integer> ans, int sum) {

        if(index < 0) {
            ans.add(sum);
            return;
        }

        helper(arr, index - 1, ans, arr[index] + sum);

        helper(arr, index - 1, ans, sum);
    }
}