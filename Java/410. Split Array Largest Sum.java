class Solution {
    public int splitArray(int[] nums, int m) {
        int N = nums.length;
        for (int i=1; i<N; i++) {
            nums[i] += nums[i-1];
            //System.out.println(nums[i]);
        }
        
        int[] dp = Arrays.copyOfRange(nums, 0, N);
        for (int i=2; i<=m; i++) {
            int[] temp = Arrays.copyOfRange(dp, 0, N);
            for (int j=i-1; j<N; j++) {
                for (int k=0; k<j; k++) {
                    dp[j] = Math.min(dp[j], Math.max(temp[k], nums[j]-nums[k]));
                }
            }
        }
        
        return dp[N-1];
    }
}