class Solution {
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < rows; c++) {
                if (grid[r][c] == 1) {
                    q.offer(new Pair(r, c));
                }
            }
        }

        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int dis = -1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Pair p = q.poll();
                for (int[] d: direction) {
                    int r = (int)p.getKey() + d[0], c = (int)p.getValue() + d[1];
                    if (0 <= r && r < rows && 0 <= c && c < rows && grid[r][c] == 0) {
                        q.offer(new Pair(r, c));
                        grid[r][c] = 1;
                    }
                }
            }
            dis++;
        }

        return dis == 0 ? -1 : dis;
    }
}