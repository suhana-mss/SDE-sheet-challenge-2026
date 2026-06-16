/*
Question Link:
https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

Question:
Schedule jobs before deadlines
to maximize total profit.
*/

class Solution {

    static class Job {
        int deadline, profit;

        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    /*
    Sort jobs by profit descending.

    Take highest profit jobs first.

    Schedule each job in the latest
    available slot before deadline.

    DSU helps quickly find
    the nearest free slot.
    */

    int find(int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        ArrayList<Job> jobs = new ArrayList<>();

        int n = deadline.length;
        int maxDeadline = 0;

        for(int i = 0; i < n; i++) {
            jobs.add(new Job(deadline[i], profit[i]));
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        Collections.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));

        int[] parent = new int[maxDeadline + 1];

        for(int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int jobCount = 0;
        int totalProfit = 0;

        for(Job job : jobs) {

            int availableSlot = find(job.deadline, parent);

            if(availableSlot > 0) {
                jobCount++;
                totalProfit += job.profit;

                parent[availableSlot] = find(availableSlot - 1, parent);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(jobCount);
        ans.add(totalProfit);

        return ans;
    }
}