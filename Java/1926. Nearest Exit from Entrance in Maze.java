class Solution {
    private int rows, cols;
    
    public int nearestExit(char[][] maze, int[] entrance) {
        rows = maze.length;
        cols = maze[0].length;
        char visited = '#';
        Queue<int[]> q = new LinkedList();
        q.offer(new int[] {entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = visited;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (isExit(entrance, cur[0], cur[1])) {
                return cur[2];
            }
            
            for (int[] d: dirs) {
                if (isValid(maze, cur[0] + d[0], cur[1] + d[1])) {
                    maze[cur[0] + d[0]][cur[1] + d[1]] = visited;
                    q.offer(new int[] {cur[0] + d[0], cur[1] + d[1], cur[2] + 1});
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValid(char[][] maze, int r, int c) {
        return 0 <= r && r < rows && 0 <= c && c < cols && maze[r][c] == '.';
    }
    
    private boolean isExit(int[] entrance, int r, int c) {
        if (r == entrance[0] && c == entrance[1]) {
            return false;
        }
        return r == 0 || r == rows - 1 || c == 0 || c == cols - 1;
    }
}