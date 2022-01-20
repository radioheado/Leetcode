/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rows = dim.get(0), cols = dim.get(1);
        int row = 0, col = cols-1;
        int res = -1;
        
        while(row < rows && col >= 0){
            if(binaryMatrix.get(row, col) == 1){
                res = col--;
            }else{
                row++;
            }
        }
        
        return res;
        
    }
}