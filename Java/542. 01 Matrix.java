class Solution {
    
    private int m, n;
    private static final int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private int[][] matt;
    
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        matt = mat;
        Queue<int[]> q = new LinkedList<>();
        
        // add all the 0s and the inital distance 1
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(mat[r][c] == 0){
                    q.add(new int[] {r, c, 1});
                }else{
                    mat[r][c] = -1;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            // System.out.println("r = " + r + ", c = " + c + ", d = " + d);
            
            for(int[] dire: directions){
                int i = dire[0];
                int j = dire[1];
                if(validMove(r+i, c+j)){
                    mat[r+i][c+j] = d;
                    q.add(new int[] {r+i, c+j, d+1});
                }
            }
        }
        
        return mat;
        
    }
    
    private boolean validMove(int r, int c){

        return 0<=r && r<m && 0<=c && c<n && (matt[r][c] == -1);
        
    }
}