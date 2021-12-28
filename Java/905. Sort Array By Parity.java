class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int odd = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2 == 0){
                swap(nums, odd++, i);
            }
        }
        return nums;
    }
    
    private void swap(int[] nums, int odd, int even){
        int temp = nums[odd];
        nums[odd] = nums[even];
        nums[even] = temp;
    }
}