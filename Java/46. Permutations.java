class Solution {
    private List<List<Integer>> ans;
    
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> newNums = new ArrayList<>();
        for(int n: nums){
            newNums.add(n);
        }
        
        backtrack(newNums, 0);
        return ans;
    }
    
    private void backtrack(List<Integer> nums, int first){
        int n = nums.size();
        if(first == n){
            ans.add(new ArrayList<Integer>(nums));
        }
        
        for(int i=first; i<n; i++){
            Collections.swap(nums, first, i);
            backtrack(nums, first+1);
            Collections.swap(nums, first, i);
        }
    }
}