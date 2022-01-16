class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> dups = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            if(dups.containsKey(nums[i])){
                if(i - dups.get(nums[i]) <= k){
                    return true;
                }
            }
            dups.put(nums[i], i);
        }
        
        return false;
    }
}