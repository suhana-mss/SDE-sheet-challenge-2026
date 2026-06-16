/*
Question Link:
https://leetcode.com/problems/trapping-rain-water/

Question:
Given elevation heights,
calculate total water trapped after rain.
*/

class Solution {

    /*
    Keep track of highest wall
    seen from left and right.

    Water at a position depends on:

    min(leftMax, rightMax)

    Move the side having smaller max
    because its trapped water
    is already determined.
    */

    public int trap(int[] height) {

        int leftMax = 0;
        int rightMax = 0;

        int sum = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {

            leftMax =
                    Math.max(leftMax, height[l]);

            rightMax =
                    Math.max(rightMax, height[r]);

            // Left side water fixed
            if (leftMax < rightMax) {

                sum += leftMax - height[l];

                l++;
            }

            // Right side water fixed
            else {

                sum += rightMax - height[r];

                r--;
            }
        }

        return sum;
    }
}