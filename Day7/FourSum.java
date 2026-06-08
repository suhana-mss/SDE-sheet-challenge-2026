/*
Question Link:
https://leetcode.com/problems/4sum/

Question:
Find all unique quadruplets such that:
nums[a] + nums[b] + nums[c] + nums[d] == target
*/

class Solution {

    /*
    Sort array first.

    Fix first two numbers using loops.

    Use two pointers for remaining two numbers.

    Skip duplicates to avoid repeated quadruplets.

    Use pruning:
    stop early when smallest possible sum
    already exceeds target
    or largest possible sum
    is still smaller than target.
    */

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        int n = nums.length;

        // Fix first number
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            long min1 =
                    (long) nums[i]
                  + nums[i + 1]
                  + nums[i + 2]
                  + nums[i + 3];

            if (min1 > target) {
                break;
            }

            long max1 =
                    (long) nums[i]
                  + nums[n - 1]
                  + nums[n - 2]
                  + nums[n - 3];

            if (max1 < target) {
                continue;
            }

            // Fix second number
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second elements
                if (j > i + 1 &&
                    nums[j] == nums[j - 1]) {

                    continue;
                }

                long min2 =
                        (long) nums[i]
                      + nums[j]
                      + nums[j + 1]
                      + nums[j + 2];

                if (min2 > target) {
                    break;
                }

                long max2 =
                        (long) nums[i]
                      + nums[j]
                      + nums[n - 1]
                      + nums[n - 2];

                if (max2 < target) {
                    continue;
                }

                // Two pointers
                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum =
                            (long) nums[i]
                          + nums[j]
                          + nums[k]
                          + nums[l];

                    // Valid quadruplet
                    if (sum == target) {

                        res.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[k],
                                nums[l]
                        ));

                        k++;
                        l--;

                        // Skip duplicate third elements
                        while (k < l &&
                                nums[k] == nums[k - 1]) {

                            k++;
                        }

                        // Skip duplicate fourth elements
                        while (k < l &&
                                nums[l] == nums[l + 1]) {

                            l--;
                        }
                    }

                    // Need larger sum
                    else if (sum < target) {

                        k++;
                    }

                    // Need smaller sum
                    else {

                        l--;
                    }
                }
            }
        }

        return res;
    }
}