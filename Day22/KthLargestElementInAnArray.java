/*
Question Link:
https://leetcode.com/problems/kth-largest-element-in-an-array/

Question:
Find the kth largest element in an array.
*/

class Solution {

    /*
    Keep only k largest elements in the heap.

    If heap size exceeds k,
    remove the smallest element.

    Heap top becomes the kth largest.
    */

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums) {
            pq.offer(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}