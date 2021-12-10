class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color == newColor){
            return image;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr, sc});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            if(image[r][c] == color){
                image[r][c] = newColor;
                if(r-1 >= 0){
                    q.offer(new int[] {r-1, c});
                }
                
                if(r+1 < image.length){
                    q.offer(new int[] {r+1, c});
                }
                
                if(c-1 >= 0){
                    q.offer(new int[] {r, c-1});
                }
                
                if(c+1 < image[0].length){
                    q.offer(new int[] {r, c+1});
                }
            }
        }
        
        return image;
    }
}