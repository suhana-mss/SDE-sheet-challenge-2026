/*
Question Link:
https://leetcode.com/problems/sudoku-solver/

Question:
Fill the Sudoku board so that
every row, column and 3×3 box
contains digits 1 to 9 exactly once.
 */

class Solution {

    /*
    Find an empty cell.

    Try digits 1 to 9.

    If valid:
    place digit and solve remaining board.

    If it fails:
    backtrack and try next digit.
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    Boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {

                        if (isValid(board, i, j, c)) {

                            board[i][j] = c;

                            if (solve(board)) {
                                return true;
                            }

                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    Boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == c) {
                return false;
            }

            if (board[i][col] == c) {
                return false;
            }

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }

        return true;
    }
}
