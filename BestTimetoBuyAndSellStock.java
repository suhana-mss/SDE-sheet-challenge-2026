class Solution {
    public int maxProfit(int[] prices) {
       int minNum= Integer.MAX_VALUE;
       int maxProfit= 0;
       // we will find minNum constantly and using that minNum and curent elemnt try to maximise profit
       for(int curNum: prices){
            minNum= Math.min(minNum, curNum);
            maxProfit= Math.max(maxProfit, curNum-minNum);
       }
       return maxProfit;
    }
}