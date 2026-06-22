/*
Question Link:
https://leetcode.com/problems/search-in-rotated-sorted-array/

Question:
Search target in rotated sorted array.
Return its index or -1.
*/

class Solution {

    /*
    One half is always sorted.

    Identify sorted half.

    Check whether target lies inside it.

    Otherwise search the other half.
    */

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            // Left half sorted
            if(nums[low] <= nums[mid]) {

                if(nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Right half sorted
            else {

                if(nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}