/*
Question Link:
https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

Question:
Find length of longest subarray
having sum equal to k.
*/

class Solution {

    /*
    Prefix Sum + HashMap.

    If:
    currentSum - previousSum = k

    then:
    subarray sum becomes k.

    Store first occurrence of prefix sums
    to maximize subarray length.
    */

    public int longestSubarray(int[] arr, int k) {

        int maxLen = 0;

        int sum = 0;

        HashMap<Integer, Integer> map =
                new HashMap<>();

        // Handles subarrays starting from index 0
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            int needed = sum - k;

            if (map.containsKey(needed)) {

                maxLen = Math.max(
                        i - map.get(needed),
                        maxLen
                );
            }

            // Store first occurrence only
            if (!map.containsKey(sum)) {

                map.put(sum, i);
            }
        }

        return maxLen;
    }
}