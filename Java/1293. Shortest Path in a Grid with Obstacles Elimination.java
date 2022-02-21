class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        
        if(k >= m+n-2) {
            return m+n-2;
        }
        
        int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, k, 0});
        Set<StepState> visited = new HashSet<>();
        visited.add(new StepState(0, 0, k, 0));
        
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], step = cur[3];
            k = cur[2];
            
            // reach the end
            if(x == m-1 && y == n-1) {
                return step;
            }
            
            for(int[] cor: directions) {
                int newx = x+cor[0];
                int newy = y+cor[1];
                
                if(validCoor(newx, newy, m, n)) {
                    int newk = k - grid[newx][newy];
                    StepState state = new StepState(newx, newy, newk, step+1);
                    if(newk >= 0 && !visited.contains(state)) {
                        visited.add(state);
                        q.offer(new int[] {newx, newy, newk, step+1});
                    }
                }
                
            }
        }
        
        return -1;
    }
    
    private boolean validCoor(int x, int y, int m, int n) {
        return (0 <= x) && (x < m) && (0 <= y) && (y < n);
    }
}


class StepState {
    /**
     * data object to keep the state info for each step:
     * <steps, row, col, remaining_eliminations>
     */
    public int steps, row, col, k;

    public StepState(int row, int col, int k, int steps) {
        this.steps = steps;
        this.row = row;
        this.col = col;
        this.k = k;
    }

    @Override
    public int hashCode() {
        // needed when we put objects into any container class
        return (this.row + 1) * (this.col + 1) * this.k;
    }

    @Override
    public boolean equals(Object other) {
        /**
         * only (row, col, k) matters as the state info
         */
        if (!(other instanceof StepState)) {
            return false;
        }
        StepState newState = (StepState) other;
        return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", this.row, this.col, this.k);
    }
}