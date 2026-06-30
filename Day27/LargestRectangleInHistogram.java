/*
Question Link:
https://leetcode.com/problems/largest-rectangle-in-histogram/

Question:
Find the largest rectangular area that can be formed
inside a histogram.
*/

class Solution {
    /*
        Maintain increasing heights in the stack.
        Whenever current bar is smaller,current bar becomes the NSE for all taller bars in the stack.
    */
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<=n; i++){
            //treat height n as height 0 to remove all remaining elements from stack
            while(!st.isEmpty() && (i==n || heights[st.peek()] >=heights[i])){
                int height= heights[st.pop()];

                //previous smaller element to the popped element
                int left = st.isEmpty() ? -1 : st.peek();
                // Current index is Next Smaller Element.
                int right = i;

                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
        
    }
}