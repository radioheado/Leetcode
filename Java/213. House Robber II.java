class Solution {
    public int rob(int[] nums) {
        if(nums == null){
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        
        int[] n1 = Arrays.copyOfRange(nums, 0, nums.length-1);
        int[] n2 = Arrays.copyOfRange(nums, 1, nums.length);
        
        return Math.max(dp(n1), dp(n2));
    }
    
    private int dp(int[] nums){
        int t1 = 0, t2 = 0;
        for(int n: nums){
            int temp = t1;
            t1 = Math.max(t1, n+t2);
            t2 = temp;
        }
        return t1;
    }
}