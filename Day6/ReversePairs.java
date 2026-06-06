class Solution {

    static int count = 0;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        count = 0;
        mergeSort(nums, 0, n-1);
        return count;
    }

    public int[] mergeSort(int[] nums, int l, int h) {
        if(l < h) {
            int mid = l + (h-l)/2;
            int[] arr1 = mergeSort(nums, l, mid);
            int[] arr2 = mergeSort(nums, mid + 1, h);
            int[] arr3 = merge(arr1, arr2);
            return arr3;
        }
        else {
            int[] arr = new int[1];
            arr[0] = nums[l];
            return arr;
        }

    }

    public int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] arr3 = new int[arr1.length + arr2.length];

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] > 2L * arr2[j]) {
                count += (arr1.length - i);
                j++;
            }

            else
                i++;
        }

        i = 0;
        j = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        while(i < arr1.length)
            arr3[k++] = arr1[i++];
        
        while(j < arr2.length)
            arr3[k++] = arr2[j++];

        return arr3;
    }
}