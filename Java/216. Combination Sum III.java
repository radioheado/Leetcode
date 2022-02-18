class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(0, new LinkedList<Integer>(), 0, k, n);
        return ans;
    }
    
    private void backtrack(int start, LinkedList<Integer> cur, int total, int k, int n) {
        if(cur.size() == k && total == n) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }else if(cur.size() >= k || total >= n) {
            return;
        }
        
        for(int i=start; i<9; i++) {
            cur.add(nums[i]);
            total += nums[i];
            backtrack(i+1, cur, total, k, n);
            total -= nums[i];
            cur.removeLast();
        }
    }
}