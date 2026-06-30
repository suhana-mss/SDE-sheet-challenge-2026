/*
Question Link:
https://www.geeksforgeeks.org/problems/sort-a-stack/1

Question:
Sort a stack using recursion only.
No extra data structure allowed.
*/

class Solution {

    /*
        Pop one element.

        Sort remaining stack.

        Insert popped element
        into its correct position.
    */
    public void sortStack(Stack<Integer> s) {

        if(s.size() <= 1) {
            return;
        }

        int top = s.pop();

        sortStack(s);

        insertSorted(s, top);
    }

    /*
        Insert x into an already
        sorted stack.
    */
    void insertSorted(Stack<Integer> s, int x) {

        if(s.isEmpty() || s.peek() <= x) {
            s.push(x);
            return;
        }

        int top = s.pop();

        insertSorted(s, x);

        s.push(top);
    }
}