class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int area = 0;
        
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                if(grid[row][col] == 1){
                    grid[row][col] = 0;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[] {row, col});
                    int island = 0;
                    
                    while(!stack.isEmpty()){
                        int[] coor = stack.pop();
                        int r = coor[0], c = coor[1];
                        island++;
                        
                        // check four adjacencies
                        for(int[] d: directions){
                            int x = r+d[0];
                            int y = c+d[1];
                            
                            if(0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == 1){
                                stack.push(new int[] {x, y});
                                grid[x][y] = 0;
                            }
                        }
                    }
                    
                    area = Math.max(area, island);
                }
            }
        }
        
        return area;
    }
    
}