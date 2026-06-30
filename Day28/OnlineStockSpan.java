/*
Question Link:
https://leetcode.com/problems/online-stock-span/

Question:
For each day's stock price,
return the span of consecutive days
having price less than or equal to today.
*/

class StockSpanner {

    int ind;
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
        ind = -1;
    }

    /*
        Remove all previous prices
        smaller than or equal to current price.

        Stack top becomes Previous Greater Element.

        Span =
        currentIndex - previousGreaterIndex.
    */
    public int next(int price) {
        ind++;

        while(!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }

        int ans = ind - (st.isEmpty() ? -1 : st.peek()[1]);

        st.push(new int[]{price, ind});

        return ans;
    }
}