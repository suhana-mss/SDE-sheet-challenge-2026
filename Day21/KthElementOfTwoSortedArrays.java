/*
Question Link:
https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1

Question:
Find the kth smallest element
from two sorted arrays.
*/

class Solution {

    /*
    Binary search on value, not index.

    Find the smallest value x such that
    count(elements <= x) > k.
    */

    public int kthElement(int[] nums1, int[] nums2, int k) {

        k--;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        if(nums1.length > 0) {
            low = Math.min(low, nums1[0]);
            high = Math.max(high, nums1[nums1.length - 1]);
        }

        if(nums2.length > 0) {
            low = Math.min(low, nums2[0]);
            high = Math.max(high, nums2[nums2.length - 1]);
        }

        while(low <= high) {

            int mid = low + (high - low) / 2;

            int count = upperBound(nums1, mid)
                      + upperBound(nums2, mid);

            if(count <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    int upperBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}