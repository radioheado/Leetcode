class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int N = coordinates.length;
        if (N == 2) return true;
        int b = coordinates[1][1] - coordinates[0][1],
            a = coordinates[1][0] - coordinates[0][0], x, y;
        
        for (int i=1; i<N-1; i++) {
            y = coordinates[i+1][1] - coordinates[i][1];
            x = coordinates[i+1][0] - coordinates[i][0];
            if (b*x != a*y) return false;
        }   
        
        return true;
    }
}