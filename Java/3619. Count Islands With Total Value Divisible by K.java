import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int ans = 0;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }

                long total = 0;
                Deque<int[]> stack = new ArrayDeque<>();
                stack.push(new int[]{r, c});

                total += grid[r][c];
                grid[r][c] = 0;

                while (!stack.isEmpty()) {
                    int[] cell = stack.pop();
                    int x = cell[0], y = cell[1];

                    for (int[] dir : dirs) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];

                        if (nx >= 0 && nx < rows &&
                            ny >= 0 && ny < cols &&
                            grid[nx][ny] > 0) {

                            total += grid[nx][ny];
                            grid[nx][ny] = 0;
                            stack.push(new int[]{nx, ny});
                        }
                    }
                }

                if (total % k == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}