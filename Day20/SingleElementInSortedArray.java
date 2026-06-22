/*
Question Link:
https://leetcode.com/problems/single-element-in-a-sorted-array/

Question:
Every element appears twice except one.
Find that single element.
*/

class Solution {

    /*
    Before single element:
    pairs start at even index.

    After single element:
    pairs start at odd index.

    Use parity of mid
    to determine search direction.
    */

    public int singleNonDuplicate(int[] nums) {

        int high = nums.length - 1;
        int low = 1;

        if(high == 0 || nums[0] != nums[1]) {
            return nums[0];
        }

        if(nums[high] != nums[high - 1]) {
            return nums[high];
        }

        while(low <= high) {

            int mid = low + (high - low) / 2;

            // Odd index
            if((mid & 1) == 1) {

                if(nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                }
                else if(nums[mid] == nums[mid + 1]) {
                    high = mid - 1;
                }
                else {
                    return nums[mid];
                }
            }

            // Even index
            else {

                if(nums[mid] == nums[mid + 1]) {
                    low = mid + 2;
                }
                else if(nums[mid] == nums[mid - 1]) {
                    high = mid - 1;
                }
                else {
                    return nums[mid];
                }
            }
        }

        return nums[low];
    }
}