/*
Question Link:
https://leetcode.com/problems/sliding-window-maximum/

Question:
Return the maximum element
for every window of size k.
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n=nums.length;
       int[] res=new int[n-k+1];
       Deque<Integer> dq=new LinkedList<>();

       for(int i=0; i<n;i++){
        //remove leftmost leaving window
        if(!dq.isEmpty() && dq.peekFirst()<=i-k){
            dq.removeFirst();
        }
        //remove leftmost if bigger elemt in window on right(decreasing monotonic stack)
        while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
            dq.removeLast();
        }
        //add value
        dq.addLast(i);
        //when window size started forming
        if(i>=k-1){
            res[i-k+1]=nums[dq.peekFirst()];
        }
       }
       return res;
    }
}