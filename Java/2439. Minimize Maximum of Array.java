class Solution {
    public int minimizeArrayValue(int[] nums) {
        long prefix = 0, ans = 0;
        for (int i=0; i<nums.length; i++) {
            prefix += nums[i];
            ans = Math.max(ans, (prefix+i) / (i+1));
        }
        return (int)ans;
    }
}