/*
Question Link:
https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

Question:
Count pairs (i, j) such that:
i < j and arr[i] > arr[j].
*/

class Solution {

    static int inversionCount(int arr[]) {

        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {

        int cnt = 0;

        if (low >= high) return cnt;

        int mid = low + (high - low) / 2;

        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);

        cnt += merge(arr, low, mid, high);

        return cnt;
    }

    static int merge(int[] arr, int low, int mid, int high) {

        List<Integer> temp = new ArrayList<>();

        int cnt = 0;

        int left = low;
        int right = mid + 1;

        // Merge sorted halves
        while (left <= mid && right <= high) {

            // No inversion
            if (arr[left] <= arr[right]) {

                temp.add(arr[left]);
                left++;

            } else {

                // Inversion occurs here
                temp.add(arr[right]);

                right++;

                cnt += mid - left + 1;
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return cnt;
    }
}