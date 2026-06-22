/*
Question Link:
https://www.geeksforgeeks.org/problems/aggressive-cows/1

Question:
Place k cows in stalls such that
minimum distance between any two cows
is maximized.
*/

class Solution {

    /*
    Binary search on answer.

    mid = minimum distance allowed.

    Possible ?
        Yes -> move right.
        No  -> move left.
    */

    public int aggressiveCows(int[] arr, int k) {

        Arrays.sort(arr);

        if(k > arr.length) {
            return -1;
        }

        int low = 1;
        int high = arr[arr.length - 1] - arr[0];

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(canPlace(arr, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    boolean canPlace(int[] stalls, int cows, int distance) {

        int count = 1;
        int lastPlaced = stalls[0];

        for(int i = 1; i < stalls.length; i++) {

            if(stalls[i] - lastPlaced >= distance) {
                count++;
                lastPlaced = stalls[i];
            }
        }

        return count >= cows;
    }
}