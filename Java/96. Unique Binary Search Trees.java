class Solution {
    public int numTrees(int n) {
        int[] subtrees = new int[n+1];
        subtrees[0] = 1;
        subtrees[1] = 1;
        
        for(int i=2; i<n+1; i++){
            for(int j=1; j<i+1; j++){
                subtrees[i] += subtrees[j-1]*subtrees[i-j];
            }
        }
        
        return subtrees[n];
    }
}