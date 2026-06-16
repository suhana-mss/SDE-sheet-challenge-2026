/*
Question Link:
https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1

Question:
Select maximum number of non-overlapping activities.
Each activity has a start and finish time.
*/

class Solution {

    /*
    Sort activities by finish time.

    Always select the activity
    that finishes earliest.

    Then take the next activity whose
    start time is greater than
    previous finish time.
    */

    static class Activity {
        int start, finish;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    public int activitySelection(int[] start, int[] finish) {

        int n = start.length;

        ArrayList<Activity> activities = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], finish[i]));
        }

        Collections.sort(activities, (a, b) -> a.finish - b.finish);

        int cnt = 1;
        int lastFinish = activities.get(0).finish;

        for(int i = 1; i < n; i++) {
            if(activities.get(i).start > lastFinish) {
                lastFinish = activities.get(i).finish;
                cnt++;
            }
        }

        return cnt;
    }
}