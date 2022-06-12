class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0, ans = 0, s = 0, n;
        /* we can use an array instead of a set because of the constraints */
        int[] count = new int[10001];
        
        for (int r=0; r<nums.length; r++) {
            n = nums[r];
            while (count[n] > 0) {
                s -= nums[l];
                count[nums[l++]]--;
            }
            count[n]++;
            s += n;
            ans = Math.max(ans, s);
        }
        
        return ans;
    }
}