class Solution {

    private HashMap<Integer, List<Integer>> indices;
    private Random rand;
    
    public Solution(int[] nums) {
        this.rand = new Random();
        this.indices = new HashMap<>();
        
        // save indices for each number
        for(int i=0; i<nums.length; i++){
            if(!this.indices.containsKey(nums[i])){
                this.indices.put(nums[i], new ArrayList<>());
            }
            this.indices.get(nums[i]).add(i);
        }
        
    }
    
    public int pick(int target) {
        int len = indices.get(target).size();
        int index = indices.get(target).get(rand.nextInt(len));
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */