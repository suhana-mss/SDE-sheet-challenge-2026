/*
Question Link:
https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

Question:
Find all paths from top-left to bottom-right
in a maze.

Allowed moves:
Down, Left, Right, Up.
*/

class Solution {

    /*
    Try all 4 directions.

    Move only to valid
    and unvisited cells.

    Mark visited before recursion.

    Unmark during backtracking.

    DLRU order gives
    lexicographically sorted answers.
    */

    public ArrayList<String> ratInMaze(int[][] maze) {

        ArrayList<String> ans = new ArrayList<>();

        int n = maze.length;

        if(maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }

        boolean[][] visited = new boolean[n][n];

        solve(0, 0, maze, n, visited, "", ans);

        return ans;
    }

    void solve(int row, int col, int[][] maze, int n,
               boolean[][] visited, String path,
               ArrayList<String> ans) {

        if(row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }

        visited[row][col] = true;

        int[] dRow = {1, 0, 0, -1};
        int[] dCol = {0, -1, 1, 0};

        String dir = "DLRU";

        for(int i = 0; i < 4; i++) {

            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if(isValid(newRow, newCol, maze, n, visited)) {
                solve(newRow, newCol, maze, n, visited,
                      path + dir.charAt(i), ans);
            }
        }

        visited[row][col] = false;
    }

    boolean isValid(int row, int col, int[][] maze,
                    int n, boolean[][] visited) {

        if(row < 0 || row >= n || col < 0 || col >= n) {
            return false;
        }

        if(visited[row][col]) {
            return false;
        }

        if(maze[row][col] == 0) {
            return false;
        }

        return true;
    }
}