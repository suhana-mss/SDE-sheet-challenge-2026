/*
Question Link:
https://leetcode.com/problems/longest-consecutive-sequence/

Question:
Find length of the longest consecutive elements sequence.
Array is unsorted.
*/

class Solution {

    /*
    Store all numbers in HashSet for O(1) lookup.

    Start counting only from numbers whose
    previous number does not exist.

    This avoids rechecking sequences repeatedly.
    */

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int mCnt = 0;

        for (int num : set) {

            // Start only from sequence beginning
            if (!set.contains(num - 1)) {

                int cnt = 0;

                while (set.contains(num)) {

                    cnt++;
                    num++;
                }

                mCnt = Math.max(cnt, mCnt);
            }
        }

        return mCnt;
    }
}