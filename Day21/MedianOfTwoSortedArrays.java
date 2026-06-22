/*
Question Link:
https://leetcode.com/problems/median-of-two-sorted-arrays/

Question:
Find median of two sorted arrays
in O(log(m+n)) time.

My first intuition:
Treat median as kth element and binary search on values.

Optimal:
Partition both arrays using binary search.
 */

class Solution {

    /*
    Binary search on the smaller array.

    Partition both arrays such that:
    1. Left side contains half the elements.
    2. Every left element <= every right element.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;

        int leftSize = (m + n + 1) / 2;

        while (low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = leftSize - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {

                if ((m + n) % 2 == 1) {
                    return Math.max(l1, l2);
                }

                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0;
    }
}
