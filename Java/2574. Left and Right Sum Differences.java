class Solution {
    public int[] leftRightDifference(int[] nums) {
        int L = nums.length;
        int[] prefix = new int[L];
        prefix[0] = nums[0];

        for (int i = 1; i < L; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] ans = new int[L];
        for (int i = 0; i < L; i++) {
            int left = i == 0 ? 0 : prefix[i - 1];
            int right = i == L - 1 ? 0 : prefix[L - 1] - prefix[i];
            ans[i] = Math.abs(right - left);
        }
        
        return ans;
    }
}