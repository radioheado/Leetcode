class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, pre = Integer.MIN_VALUE;

        for (int n: nums) {
            int cur = Math.min(Math.max(pre + 1, n - k), n + k);
            if (cur > pre) {
                ans++;
                pre = cur;
            }
        }

        return ans;
    }
}