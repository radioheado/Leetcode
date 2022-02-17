class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, new LinkedList<Integer>(), 0, 0, target);
        return ans;
    }
    
    private void backtrack(int[] can, LinkedList<Integer> cur, int sum, int start, int target) {
        if(sum == target) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }else if(sum > target) {
            return;
        }
        
        for(int i=start; i<can.length; i++) {
            cur.add(can[i]);
            sum += can[i];
            backtrack(can, cur, sum, i, target);
            sum -= can[i];
            cur.removeLast();
        }
    }
}