class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int subsum = 0, res = 0;
        
        for(int i=0; i<nums.length; i++){
            subsum = (subsum+nums[i])%k;
            
            // deal with negative remains
            if(subsum < 0){
                subsum += k;
            }
            
            if(prefix.containsKey(subsum)){
                res += prefix.get(subsum);
            }
            
            prefix.put(subsum, prefix.getOrDefault(subsum, 0)+1);
        }
        
        return res;
    }
}