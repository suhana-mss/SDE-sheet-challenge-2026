/*
Question Link:
https://leetcode.com/problems/top-k-frequent-elements/

Question:
Return the k most frequent elements.
*/

class Solution {

    /*
    Count frequency.

    Keep only k most frequent elements
    inside a min heap.

    Heap top always stores the least
    frequent among the current top k.
    */

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) ->
                map.get(a) - map.get(b));

        for(int num : map.keySet()) {

            pq.offer(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for(int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}