class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new LinkedList<Integer>(), 0, 0, candidates, target);
        return ans;
    }
    
    private void backtrack(LinkedList<Integer> cur, int start, int total, int[] can, int target) {
        if(total == target) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }else if(total > target) {
            return;
        }
        
        for(int i=start; i<can.length; i++) {
            if(i > start && can[i] == can[i-1]) {
                continue;
            }
            cur.add(can[i]);
            total += can[i];
            backtrack(cur, i+1, total, can, target);
            total -= can[i];
            cur.removeLast();
        }
    }
}