/*
Question Link:
https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

Question:
Maximize value that can be carried
inside knapsack of fixed capacity.

Fractions of items are allowed.
*/

class Solution {

    /*
    Sort items by value/weight ratio.

    Take complete item
    if it fits.

    Otherwise take only the required
    fraction and stop.
    */

    static class Knapsack {
        int val, wt;
        double ratio;

        Knapsack(int val, int wt, double ratio) {
            this.val = val;
            this.wt = wt;
            this.ratio = ratio;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        ArrayList<Knapsack> knaps = new ArrayList<>();

        int n = val.length;

        for(int i = 0; i < n; i++) {
            knaps.add(new Knapsack(val[i], wt[i], (double) val[i] / wt[i]));
        }

        Collections.sort(knaps, (a, b) -> Double.compare(b.ratio, a.ratio));

        double sum = 0;

        for(Knapsack knap : knaps) {

            if(capacity <= 0) {
                break;
            }

            if(knap.wt <= capacity) {
                capacity -= knap.wt;
                sum += knap.val;
            } else {
                sum += ((double) capacity / knap.wt) * knap.val;
                capacity = 0;
            }
        }

        return sum;
    }
}