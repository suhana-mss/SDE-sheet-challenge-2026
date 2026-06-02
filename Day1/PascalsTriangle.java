class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int r = 0; r < numRows; r++) {
            ans.add(generateRow(r));
        }
        return ans;
    }
    public static List<Integer> generateRow(int r) {
        long val = 1;
        List<Integer> row = new ArrayList<>();
        row.add(1); 

        for (int c = 1; c <= r; c++) {
            val = val * (r - c + 1) / c;
            row.add((int) val);
        }

        return row;
    }
}