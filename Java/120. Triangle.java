class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevRow = triangle.get(0);
        
        for(int row=1; row<triangle.size(); row++){
            List<Integer> curRow = new ArrayList<>();
            
            for(int col=0; col<=row; col++){
                int left = col >= 1 ? col-1 : 0;
                int right = col < triangle.get(row-1).size() ? col : triangle.get(row-1).size()-1;
                curRow.add(Math.min(prevRow.get(left), prevRow.get(right)) + triangle.get(row).get(col));
            }
            prevRow = curRow;
        }
        
        return Collections.min(prevRow);
    }
}