class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {

        int n = a.length;

        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((x, y) -> Integer.compare(y[0], x[0]));

        Set<Long> visited = new HashSet<>();

        maxHeap.offer(new int[]{a[n - 1] + b[n - 1], n - 1, n - 1});
        visited.add(((long)(n - 1) << 32) | (n - 1));

        ArrayList<Integer> res = new ArrayList<>();

        while (k-- > 0 && !maxHeap.isEmpty()) {

            int[] curr = maxHeap.poll();
            int sum = curr[0], i = curr[1], j = curr[2];

            res.add(sum);

            if (i - 1 >= 0) {
                long key = ((long)(i - 1) << 32) | j;

                if (!visited.contains(key)) {
                    maxHeap.offer(new int[]{a[i - 1] + b[j], i - 1, j});
                    visited.add(key);
                }
            }

            if (j - 1 >= 0) {
                long key = ((long)i << 32) | (j - 1);

                if (!visited.contains(key)) {
                    maxHeap.offer(new int[]{a[i] + b[j - 1], i, j - 1});
                    visited.add(key);
                }
            }
        }

        return res;
    }
}