class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1, pre = nums[0];

        for (int n: nums) {
            if (n - pre > k) {
                ans++;
                pre = n;
            }
        }

        return ans;
    }
}