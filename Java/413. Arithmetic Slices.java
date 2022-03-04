class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int L = nums.length;
        if(L < 3) {
            return 0;
        }
        
        int diff = 0, start = 0, ans = 0;
        for(int i=1; i<L; i++) {
            if(nums[i] - nums[i-1] != diff) {
                if(i-start >= 2) {
                    ans += ((i-start-1) * (i-start-2)) / 2;
                }
                diff = nums[i] - nums[i-1];
                start = i-1;
            }
        }
        
        if(L-start >= 3) {
            ans += ((L-start-1) * (L-start-2)) / 2;
        }
        
        return ans;
        
    }
}