/*
Question Link:
https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

Question:
Find median of a row-wise sorted matrix.
*/

class Solution {

    /*
    Binary search on value range, not indices.

    For every mid:
    count how many elements are <= mid.

    If count <= required:
    median is larger.

    Else:
    median may be mid or smaller.
    */

    int median(int mat[][]) {

        int n = mat.length;
        int m = mat[0].length;

        int required = (n * m) / 2;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m - 1]);
        }

        while(low <= high) {

            int mid = low + (high - low) / 2;

            int count = 0;

            for(int i = 0; i < n; i++) {
                count += upperBound(mat[i], mid);
            }

            if(count <= required) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    /*
    Returns count of elements <= target.
    */

    int upperBound(int[] row, int target) {

        int low = 0;
        int high = row.length - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}