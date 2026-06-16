/*
Question Link:
https://leetcode.com/problems/3sum/

Question:
Find all unique triplets such that:
nums[i] + nums[j] + nums[k] = 0
*/

import java.util.*;

class Solution {

    /*
    Sort array first.

    Fix first element.

    Use two pointers for remaining pair.

    Skip duplicates for:
    first element,
    second element,
    third element.

    This ensures unique triplets only.
    */

    public List<List<Integer>> threeSum(int[] ar) {

        Arrays.sort(ar);

        int n = ar.length;

        List<List<Integer>> arr =
                new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {

            if (i > 0 &&
                ar[i] == ar[i - 1]) {

                continue;
            }

            int second = i + 1;

            int third = n - 1;

            while (second < third) {

                int sum =
                        ar[i]
                      + ar[second]
                      + ar[third];

                if (sum == 0) {

                    arr.add(Arrays.asList(
                            ar[i],
                            ar[second],
                            ar[third]
                    ));

                    // Skip duplicate second values
                    while (second < third &&
                           ar[second] ==
                           ar[second + 1]) {

                        second++;
                    }

                    // Skip duplicate third values
                    while (second < third &&
                           ar[third] ==
                           ar[third - 1]) {

                        third--;
                    }

                    second++;
                    third--;

                } else if (sum < 0) {

                    second++;

                } else {

                    third--;
                }
            }
        }

        return arr;
    }
}