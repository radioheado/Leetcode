class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0, prev = 0, res = 0, zero = 0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zero = 1;
                prev = cur;
                cur = 0;
            }else{
                cur++;
            }
            
            res = Math.max(res, cur+prev+zero);
        }
        
        return res;
    }
}