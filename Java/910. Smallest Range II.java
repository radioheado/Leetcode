class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int l = nums.length;
        if (l < 2)    return 0;
        
        Arrays.sort(nums);
        int min = nums[0]+k, max = nums[l-1]-k, ans = nums[l-1] - nums[0], a, b;
        
        for (int i=0; i<l-1; i++) {
            a = nums[i];
            b = nums[i+1];
            ans = Math.min(ans, Math.max(max, a+k) - Math.min(min, b-k));
        }
        
        return ans;
    }
}