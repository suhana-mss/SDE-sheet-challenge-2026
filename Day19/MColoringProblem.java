/*
Question Link:
https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1

Question:
Determine whether a graph can be colored using at most m colors
such that no adjacent vertices have the same color.
*/

class Solution {

    public boolean graphColoring(int v, int[][] edges, int m) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create adjacency list
        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list
        for(int[] edge : edges) {
            int u = edge[0];
            int w = edge[1];

            adj.get(u).add(w);
            adj.get(w).add(u);
        }

        int[] colors = new int[v];

        return solve(0, colors, adj, m, v);
    }

    /*
    Try every color for current node.

    If safe:
    assign color and recurse.

    If it fails:
    remove color and try next one.
    */

    boolean solve(int node, int[] colors, ArrayList<ArrayList<Integer>> adj, int m, int v) {

        if(node == v) {
            return true;
        }

        for(int color = 1; color <= m; color++) {

            if(isSafe(node, color, colors, adj)) {

                colors[node] = color;

                if(solve(node + 1, colors, adj, m, v)) {
                    return true;
                }

                colors[node] = 0;
            }
        }

        return false;
    }

    boolean isSafe(int node, int color, int[] colors, ArrayList<ArrayList<Integer>> adj) {

        for(int neighbour : adj.get(node)) {

            if(colors[neighbour] == color) {
                return false;
            }
        }

        return true;
    }
}