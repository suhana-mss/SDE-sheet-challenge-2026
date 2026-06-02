class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
       int i=n-2; 
       while(i>=0 && nums[i]>=nums[i+1]){
        i--;
       }
       if(i>=0){
        int j=n-1;
        while(nums[j]<=nums[i]){
            j--;
        }
        swap(nums,i,j);
       }
       rev(nums,i+1,n-1);
    }
    public void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    public void rev(int[] nums,int s,int e){
        while(s<e){
            swap(nums,s,e);
            s++;
            e--;
        }
    }
}