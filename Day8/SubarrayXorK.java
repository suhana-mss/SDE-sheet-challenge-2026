/*
Question Link:
https://www.geeksforgeeks.org/problems/subarrays-with-xor-k/1

Question:
Count subarrays whose XOR equals k.
*/

class Solution {

    /*
    Store frequency of previous XOR values.

    If:
    currentXor ^ previousXor = k

    then:
    previousXor = currentXor ^ k

    Meaning:
    subarray XOR between them becomes k.
    */

    public long subarrayXor(int arr[], int k) {

        int count = 0;

        int xor = 0;

        HashMap<Integer, Integer> map =
                new HashMap<>();

        // Handles subarrays starting from index 0
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {

            xor = xor ^ arr[i];

            int needed = xor ^ k;

            count += map.getOrDefault(needed, 0);

            map.put(
                    xor,
                    map.getOrDefault(xor, 0) + 1
            );
        }

        return count;
    }
}