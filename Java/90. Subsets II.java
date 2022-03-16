class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new LinkedList<Integer>());
        return ans;
    }
    
    private void backtrack (int[]nums, int start, LinkedList<Integer> cur) {
        ans.add(new ArrayList<>(cur));
        for (int i=start; i<nums.length; i++) {
            /* found a duplicate */
            if (i != start && nums[i] == nums[i-1]) {
                continue;
            }
            
            cur.add(nums[i]);
            backtrack(nums, i+1, cur);
            cur.removeLast();
        }
    }
}