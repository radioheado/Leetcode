class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        if(nums.length == 1){
            return false;
        }
        
        HashMap<Integer, Integer> remainders = new HashMap<>();
        int total = 0;
        remainders.put(0, -1);
        
        for(int i=0; i<nums.length; i++){
            total += nums[i];
            int rem = total%k;
            if(remainders.containsKey(rem)){
                if(i-remainders.get(rem)>1){
                    return true;
                }
              
            }else{
                remainders.put(rem, i);
            }
        }
        
        return false;
    }
}