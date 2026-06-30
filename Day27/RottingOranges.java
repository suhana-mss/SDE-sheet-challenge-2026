/*
Question Link:
https://leetcode.com/problems/rotting-oranges/

Question:
Find the minimum time required
to rot all fresh oranges.
Return -1 if impossible.
*/

class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // Put all rotten oranges in queue.
        // Count fresh oranges.
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges.
        if(fresh == 0) {
            return 0;
        }

        int minutes = 0;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        // Multi-source BFS.
        while(!queue.isEmpty()) {

            int size = queue.size();
            boolean rotted = false;

            // Process one minute.
            for(int i = 0; i < size; i++) {

                int[] cell = queue.poll();

                int row = cell[0];
                int col = cell[1];

                // Visit all 4 directions.
                for(int j = 0; j < 4; j++) {

                    int newRow = row + dRow[j];
                    int newCol = col + dCol[j];

                    // Valid fresh orange.
                    if(newRow >= 0 && newRow < m &&
                       newCol >= 0 && newCol < n &&
                       grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;

                        fresh--;

                        queue.offer(new int[]{newRow, newCol});

                        rotted = true;
                    }
                }
            }

            // One minute passed only if at least one orange became rotten.
            if(rotted) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}