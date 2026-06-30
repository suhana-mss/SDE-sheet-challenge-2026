/*
Question Link:
https://www.geeksforgeeks.org/problems/the-celebrity-problem/1

Question:
Find the celebrity.

Celebrity:
1. Knows nobody.
2. Everybody knows them.
*/

class Solution {

    /*
        Eliminate one person
        in every comparison.

        If A knows B:
        A cannot be celebrity.

        Else:
        B cannot be celebrity.

        Verify the final candidate.
    */
    public int celebrity(int M[][]) {

        int n = M.length;

        int top = 0;
        int down = n - 1;

        while(top < down) {

            if(M[top][down] == 1) {
                top++;
            }
            else {
                down--;
            }
        }

        int candidate = top;

        for(int i = 0; i < n; i++) {

            if(i == candidate) {
                continue;
            }

            if(M[candidate][i] == 1 || M[i][candidate] == 0) {
                return -1;
            }
        }

        return candidate;
    }
}