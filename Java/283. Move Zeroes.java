class Solution {
    public void moveZeroes(int[] nums) {
        int zeros = 0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                zeros++;
                continue;
            }    
            if(zeros > 0){
                nums[i-zeros] = nums[i];
            }
        }
        
        while(zeros>0){
            nums[nums.length-zeros] = 0;
            zeros--;
        }
        
    }
}