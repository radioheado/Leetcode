class Solution {
    public int getMaxLen(int[] nums) {
        int prod = 1, ans = 0, start = 0, n = nums.length;
        for(int i=0; i<n; i++){
            prod *= nums[i] > 0 ? 1 : -1;
            
            if(nums[i] == 0){
                prod = 1;
                start = i+1;
                continue;
            }else if(prod < 0 && (i == n-1 || nums[i+1] == 0)){
                while(start <= i && prod < 0){
                    if(nums[start] < 0){
                        prod *= -1;
                    }
                    start++;
                }
            }
            
            if(prod > 0){
                ans = Math.max(ans, i-start+1);
            }
        }
        
        return ans;
    }
}