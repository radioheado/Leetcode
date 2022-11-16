class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n: nums) {
            total += n;
        }
        
        if (total % 2 != 0) {
            return false;
        }
        
        int subtotal = total / 2;
        boolean dp[] = new boolean[subtotal + 1];
        dp[0] = true;
        
        for (int n: nums) {
            for (int j=subtotal; j>=n; j--) {
                dp[j] |= dp[j - n];
            }
        }
        
        return dp[subtotal];
    }
}