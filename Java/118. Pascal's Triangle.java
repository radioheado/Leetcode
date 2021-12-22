class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        // add the initial [1] to result
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);
        
        for(int n=1; n<numRows; n++){
            List<Integer> temp = new ArrayList<>();
            // get the previous list to compute
            List<Integer> prev = result.get(n-1);
            
            // add the starting 1 to the temp list
            temp.add(1);
            
            for(int j=1; j<n; j++){
                temp.add(prev.get(j-1)+prev.get(j));
            }
            
            // add the ending 1 to the temp list
            temp.add(1);
            
            // add temp list to the result list
            result.add(temp);
        }
        
        return result;
    }
}