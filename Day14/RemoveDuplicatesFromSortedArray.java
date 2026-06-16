/*
Question Link:
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Question:
Remove duplicates from sorted array in-place.
Return count of unique elements.
*/

class Solution {

    /*
    i stores next position
    for unique element.

    j scans array.

    Whenever new unique value is found:
    copy it to i and move i forward.
    */

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 1;
        int j = 1;

        int n = nums.length;

        while (j < n && i < n) {

            if (nums[j] != nums[j - 1]) {

                nums[i] = nums[j];

                i++;
            }

            j++;
        }

        return i;
    }
}