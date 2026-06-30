/*
Question Link:
https://www.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1

Question:
For every window size from 1 to n,
find the maximum among all minimums
of that window size.
*/

class Solution {

    /*
        Treat every element as the minimum.

        Using Previous Smaller and Next Smaller,
        find the largest window where arr[i]
        remains the minimum.

        Then update:
        answer[windowLength].

        Finally fill missing window sizes
        from right to left.
    */
    public ArrayList<Integer> maxOfMins(int[] arr) {

        int n = arr.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        findPSE(arr, pse);
        findNSE(arr, nse);

        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MIN_VALUE);

        for(int i = 0; i < n; i++) {

            int len = nse[i] - pse[i] - 1;

            ans[len] = Math.max(ans[len], arr[i]);
        }

        for(int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            res.add(ans[i]);
        }

        return res;
    }

    void findPSE(int[] arr, int[] pse) {

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i++) {

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
    }

    void findNSE(int[] arr, int[] nse) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }
    }
}