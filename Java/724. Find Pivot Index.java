class Solution {
    public int pivotIndex(int[] nums) {
        int right = 0, left = 0;
        
        for(int num: nums){
            right += num;
        }
        
        for(int i=0; i<nums.length; i++){
            right -= nums[i];
            if(left == right){
                return i;
            }
            left += nums[i];
        }
        
        return -1;
    }
}