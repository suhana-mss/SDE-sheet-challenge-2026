/*
Question Link:
https://leetcode.com/problems/set-mismatch/

Question:
One number in array appears twice and one number is missing.
Return [duplicate, missing].
*/

class Solution {

    public int[] findErrorNums(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            int correctIndex = nums[i] - 1;

            // Place current number at correct index
            if (nums[i] != nums[correctIndex]) {

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

            } else {
                i++;
            }
        }

        // Find mismatch
        for (i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }

        return new int[]{-1, -1};
    }
}