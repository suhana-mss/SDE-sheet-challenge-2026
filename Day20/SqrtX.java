/*
Question Link:
https://leetcode.com/problems/sqrtx/

Question:
Return floor value of square root of x.
*/

class Solution {

    /*
    Binary search on answer.

    If mid² <= x:
    move right.

    Otherwise:
    move left.

    Final answer is high.
    */

    public int mySqrt(int x) {

        if(x == 1) {
            return 1;
        }

        long low = 2;
        long high = x / 2;

        while(low <= high) {

            long mid = low + (high - low) / 2;

            if(mid * mid < x) {
                low = mid + 1;
            }
            else if(mid * mid > x) {
                high = mid - 1;
            }
            else {
                return (int) mid;
            }
        }

        return (int) high;
    }
}