/*
Question Link:
https://leetcode.com/problems/n-queens/

Question:
Place N queens on an N×N board
such that no two queens attack each other.
*/

class Solution {

    /*
    Place one queen in each column.

    Try every row.

    Place queen only if position is safe.

    Backtrack after exploring.
    */

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for(char[] row : board) {
            Arrays.fill(row, '.');
        }

        solve(0, board, ans, n);

        return ans;
    }

    void solve(int col, char[][] board, List<List<String>> ans, int n) {

        if(col == n) {
            ans.add(construct(board));
            return;
        }

        for(int row = 0; row < n; row++) {

            if(isSafe(row, col, board, n)) {

                board[row][col] = 'Q';

                solve(col + 1, board, ans, n);

                board[row][col] = '.';
            }
        }
    }

    Boolean isSafe(int row, int col, char[][] board, int n) {

        int originalRow = row;
        int originalCol = col;

        // Upper diagonal
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = originalRow;
        col = originalCol;

        // Left side
        while(col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = originalRow;
        col = originalCol;

        // Lower diagonal
        while(row < n && col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    List<String> construct(char[][] board) {

        List<String> res = new ArrayList<>();

        for(char[] row : board) {
            res.add(new String(row));
        }

        return res;
    }
}