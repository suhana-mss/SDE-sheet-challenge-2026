/*
Question Link:
https://leetcode.com/problems/next-greater-element-i/

Question:
For every element in nums1,
find its next greater element in nums2.
*/

class Solution {

    /*
        Use a decreasing monotonic stack.

        Remove smaller elements.

        Stack top becomes
        the next greater element.
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i = nums2.length - 1; i >= 0; i--) {

            int num = nums2[i];

            while(!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }

            map.put(num, st.isEmpty() ? -1 : st.peek());

            st.push(num);
        }

        int[] ans = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}