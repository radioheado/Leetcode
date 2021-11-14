class Solution {
    
    List<List<Integer>> answer = new LinkedList();
    int[] nums;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        
        backtrack(0, new LinkedList<Integer>());
        return answer;
    }
    
    private void backtrack(int start, LinkedList<Integer> cur){
        answer.add(new LinkedList(cur));
        
        for(int i=start; i<nums.length; i++){
            cur.add(nums[i]);
            backtrack(i+1, cur);
            cur.removeLast();
        }
    }
}