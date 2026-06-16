/*
Question Link:
https://leetcode.com/problems/max-consecutive-ones/

Question:
Find maximum number of consecutive 1s
in a binary array.
*/

class Solution {

    /*
    Keep current streak length.

    Reset on 0.

    Update maximum streak continuously.
    */

    public int findMaxConsecutiveOnes(int[] nums) {

        int curCount = 0;

        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {

                curCount = 0;

            } else {

                curCount++;
            }

            maxCount =
                    Math.max(maxCount, curCount);
        }

        return maxCount;
    }
}