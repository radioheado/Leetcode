class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int l = 0, n = nums.length, chars_over_k = 0;

        for (int r = 0; r < n; r++) {
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);
            if (count.get(nums[r]) == k + 1) {
                chars_over_k++;
            }
            if (chars_over_k > 0) {
                count.put(nums[l], count.get(nums[l]) - 1);
                if (count.get(nums[l]) == k) {
                    chars_over_k--;
                }
                l++;
            }
        }
        return n - l;
    }
}