/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    // up, right, down, left
    private static final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;
    
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
        
    }
    
    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
    private void backtrack(int row, int col, int d) {
        visited.add(new Pair(row, col));
        robot.clean();
        
        for(int i=0; i<4; i++){
            int new_d = (d+i)%4;
            int new_row = row+directions[new_d][0];
            int new_col = col+directions[new_d][1];
            
            if(!visited.contains(new Pair(new_row, new_col)) && robot.move()) {
                backtrack(new_row, new_col, new_d);
                goBack();
            }
            
            // turn clockwise
            robot.turnRight();
        }
    }
}