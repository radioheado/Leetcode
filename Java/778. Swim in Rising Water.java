class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length, ans = 0;
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((k1, k2) -> 
                                            grid[k1 / N][k1 % N] - grid[k2 / N][k2 % N]);

        heap.offer(0);
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        while (!heap.isEmpty()) {
            int k = heap.poll();
            int r = k / N, c = k % N;
            ans = Math.max(ans, grid[r][c]);
            if (r == N - 1 && c == N - 1) {
                return ans;
            }

            for (int i = 0; i < 4; i++) {
                int x = r + dr[i], y = c + dc[i];
                int ck = x * N + y;
                if (0 <= x && x < N && 0 <= y && y < N && !seen.contains(ck)) {
                    heap.offer(ck);
                    seen.add(ck);
                }
            }
        }
        return ans;
    }
}