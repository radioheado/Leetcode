class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int comp = target - nums[i];
            if(indices.containsKey(comp)){
                return new int[] {i, indices.get(comp)};
            }
            indices.put(nums[i], i);
        }
        
        return null;
        
    }
}