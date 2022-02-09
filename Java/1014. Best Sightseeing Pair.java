class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int lmax = values[0], ans = 0;
        
        for(int i=1; i<values.length; i++){
            ans = Math.max(ans, lmax-1+values[i]);
            lmax = Math.max(lmax-1, values[i]);
        }
        
        return ans;
    }
}