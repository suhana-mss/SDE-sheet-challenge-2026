class Solution {
    public void sortColors(int[] nums) {
    int low=0;
    int mid=0;
    int high=nums.length-1;

    // if encounter 0 then swap & low,mid moves forwrd, if 1 then mid moves frwrd, if 2 then swap mid,high and high moves back and mid moves frwrd 
    while(mid<=high){
        if(nums[mid]==0){
            swap(nums, mid,low);
            low++;
            mid++;
        }
        else if(nums[mid]==1){
            mid++;
        }
        else{
            swap(nums, mid, high);
            high--;
        }
    }    
    }

    //swapping funct
    private static void swap(int[] arr, int mid, int oth){
        int temp=arr[oth];
        arr[oth]=arr[mid];
        arr[mid]=temp;
    }
}