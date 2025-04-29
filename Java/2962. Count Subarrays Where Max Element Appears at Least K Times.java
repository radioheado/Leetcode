class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max_num = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int l = 0, count = 0;

        for (int r = 0; r < nums.length; r++) {
            count += nums[r] == max_num ? 1 : 0;
            while (count == k) {
                count -= nums[l] == max_num ? 1 : 0;
                l++;
            }
            ans += l;
        }

        return ans;
    }
}