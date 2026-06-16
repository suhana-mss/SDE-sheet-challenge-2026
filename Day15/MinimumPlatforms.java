/*
Question Link:
https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

Question:
Find minimum number of railway platforms
required so that no train waits.
*/

class Solution {

    /*
    Sort arrivals and departures.

    Process whichever event happens first.

    Current overlapping trains
    = platforms currently needed.

    Maximum overlap
    = minimum platforms required.
    */

    public int minPlatform(int arr[], int dep[]) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int n = arr.length;

        int count = 0;
        int maxCount = 0;

        while(i < n) {

            if(arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}