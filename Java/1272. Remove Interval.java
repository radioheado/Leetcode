class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList();
        int rs = toBeRemoved[0], re = toBeRemoved[1];
        int s, e;
        
        for (int[] pair: intervals) {
            s = pair[0];
            e = pair[1];
            
            // no overlap
            if (e < rs || s > re) {
                ans.add(Arrays.asList(s, e));
            } else {
                // keep left half
                if (s < rs) {
                    ans.add(Arrays.asList(s, rs));
                }
                // keep right half
                if (e > re) {
                    ans.add(Arrays.asList(re, e));
                }
            }
        }
        
        return ans;
    }
}