/*
Question Link:
https://leetcode.com/problems/two-sum/

Question:
Find indices of two numbers such that:
nums[i] + nums[j] == target
*/

class Solution {

    /*
    Store visited numbers with indices
    in HashMap.

    For each element:
    check whether required remaining value
    already exists.
    */

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map =
                new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int needed = target - nums[i];

            if (map.containsKey(needed)) {

                return new int[]{
                        map.get(needed),
                        i
                };
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}