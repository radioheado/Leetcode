class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        Map<Integer, Integer> num_count = new HashMap<>();
        int distinct_count = 0, N = nums.length;
        int[] ans = new int[N - k + 1];

        for (int i = 0; i < N; i++) {
            if (num_count.getOrDefault(nums[i], 0) == 0) {
                distinct_count++;
            }
            num_count.put(nums[i], num_count.getOrDefault(nums[i], 0) + 1);
            if (i >= k) {
                num_count.put(nums[i - k], num_count.get(nums[i - k]) - 1);
                if (num_count.get(nums[i - k]) == 0) {
                    distinct_count--;
                }
            }

            if (i >= k - 1) {
                ans[i - k + 1] = distinct_count;
            }
        }
        return ans;
    }
}