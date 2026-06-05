class Solution {
    public int findDuplicate(int[] nums) {
       boolean[] seen=new boolean[nums.length+1];
       for(int n:nums){
        if(seen[n]){
            return n;
        }
        seen[n]=true;
       }
        return -1;
    }
}