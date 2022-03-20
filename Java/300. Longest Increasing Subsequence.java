class Solution {
    public int lengthOfLIS(int[] nums) {
        int L = nums.length;
        int ans = 1;
        int[] dp = new int[L];
        Arrays.fill(dp, 1);
        
        for (int i=1; i<L; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                } 
            }
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}