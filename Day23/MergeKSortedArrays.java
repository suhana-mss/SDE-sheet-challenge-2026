class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        ArrayList<Integer> res=new ArrayList<>();
        for(int[] row:mat){
            for(int value:row){
                res.add(value);
            }
        }
        Collections.sort(res);
        return res;
    }
}