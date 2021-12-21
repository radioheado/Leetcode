class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int VISITED = 101;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // four directions to move: right, down, left, up
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        // initial direction: move right
        int curDir = 0;
        
        // the number of how many times we change the direction
        int change = 0;
        
        // current position is (row, col)
        int row = 0, col = 0;
        
        // make a result list, and add the first element
        // also mark it as VISITED
        List<Integer> result = new ArrayList<>();
        result.add(matrix[row][col]);
        matrix[row][col] = VISITED;
        
        while(change < 2){
            while(row + directions[curDir][0] >= 0   &&
                  row + directions[curDir][0] < rows &&
                  col + directions[curDir][1] >= 0   &&
                  col + directions[curDir][1] < cols &&
                  matrix[row+directions[curDir][0]][col + directions[curDir][1]] != VISITED){
                
                // reset change to 0
                change = 0;
                
                // update the indices
                row += directions[curDir][0];
                col += directions[curDir][1];
                
                result.add(matrix[row][col]);
                matrix[row][col] = VISITED;
            }
            // change the current direction by incrementing once
            curDir = (curDir+1)%4;
            change++;
        }
        
        return result;
    }
}