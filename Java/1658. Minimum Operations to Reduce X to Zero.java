class Solution {
    public int minOperations(int[] nums, int x) {
        int cur = 0, l = 0, ans = Integer.MAX_VALUE, N = nums.length;
        
        for (int n: nums) {
            cur += n;
        }
        
        for (int r=0; r<N; r++) {
            cur -= nums[r];
            while (cur < x && l <= r) {
                cur += nums[l++];
            }
            if (cur == x) {
                ans = Math.min(ans, N-1-r+l);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}