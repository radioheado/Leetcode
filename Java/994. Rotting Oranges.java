class Solution {
    private int m, n;
    private static final int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, minutes = 0;
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] == 2){
                    q.offer(new int[] {r, c, 0});
                }else if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0], c = temp[1], m = temp[2];
            minutes = Math.max(minutes, m);
            for(int[] d: directions){
                int x = r+d[0], y = c+d[1];
                if(validMove(grid, x, y)){
                    grid[x][y] = 2;
                    fresh--;
                    q.offer(new int[] {x, y, m+1});
                }
                
            }
        }
        return fresh == 0 ?  minutes : -1;
    }
    
    
    private boolean validMove(int[][] grid, int r, int c){
        return 0<=r && r<m && 0<=c && c<n && (grid[r][c] == 1);
    }
}