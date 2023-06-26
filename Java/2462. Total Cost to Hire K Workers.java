class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int l = 0; l < candidates; l++) {
            pq.offer(new int[] {costs[l], 0});
        }

        int n = costs.length;
        for (int r = Math.max(candidates, n - candidates); r < n; r++) {
            pq.offer(new int[] {costs[r], 1});
        }

        long total = 0;
        int l = candidates, r = n - candidates - 1;

        for (int i = 0; i < k; i++) {
            int[] cur = pq.poll();
            total += cur[0];

            if (l <= r) {
                if (cur[1] == 0) {
                    pq.offer(new int[] {costs[l++], 0});
                } else {
                    pq.offer(new int[] {costs[r--], 1});
                }
            }
        }
        return total;
    }
}