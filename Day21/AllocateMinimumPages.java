/*
Question Link:
https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

Question:
Allocate books among students such that
maximum pages assigned to any student
is minimized.
*/

class Solution {

    /*
    Binary search on answer.

    mid = maximum pages allowed.

    Possible ?
        Yes -> try smaller.
        No  -> increase.
    */

    public int findPages(int[] arr, int k) {

        if(k > arr.length) {
            return -1;
        }

        int low = 0;
        int high = 0;

        for(int pages : arr) {
            high += pages;
            low = Math.max(low, pages);
        }

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(canAllocate(arr, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    boolean canAllocate(int[] books, int students, int maxPages) {

        int usedStudents = 1;
        int currentPages = 0;

        for(int pages : books) {

            if(currentPages + pages > maxPages) {
                usedStudents++;
                currentPages = 0;
            }

            currentPages += pages;
        }

        return usedStudents <= students;
    }
}