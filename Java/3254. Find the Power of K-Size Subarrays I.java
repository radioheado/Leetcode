class Solution {
    public int[] resultsArray(int[] nums, int k) {
        // Special case
        if (k == 1) {
            return nums;
        }

        int N = nums.length, prefix = 1;
        int[] ans = new int[N - k + 1];
        Arrays.fill(ans, -1);

        for (int i = 0; i < N - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                prefix++;
            } else {
                prefix = 1;
            }

            if (prefix >= k) {
                ans[i - k + 2] = nums[i + 1];
            }
        }
        return ans;
    }
}