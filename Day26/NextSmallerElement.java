/*
Question Link:
https://www.geeksforgeeks.org/problems/help-classmates--141631/1

Question:
For every element,
find the first smaller element on its right.
*/

class Solution {

    /*
        Traverse from right to left.

        Remove all elements that cannot
        be the next smaller element.

        Stack top becomes the answer.
    */
    public static int[] help_classmate(int arr[], int n) {

        Stack<Integer> stack = new Stack<>();
        int[] output = new int[n];

        for(int i = n - 1; i >= 0; i--) {

            while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            output[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return output;
    }
}