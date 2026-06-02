class Solution {
    public int maxSubArray(int[] nums) {
     int maxsofar=nums[0];
     int currMax=nums[0]; 
     for(int i=1;i<nums.length;i++){
        currMax=Math.max(nums[i],currMax+nums[i]);
        maxsofar=Math.max(maxsofar,currMax);
     }
     return maxsofar;  
    }
}