class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> num_count = new HashSet<>();
        for (int n: nums) {
            num_count.add(n);
        }

        Map<Integer, Integer> cur_count = new HashMap<>();
        int total_count = num_count.size(), r = 0, ans = 0, total = nums.length;
        for (int l = 0; l < total; l++) {
            if (l > 0) {
                int remove = nums[l - 1];
                cur_count.put(remove, cur_count.get(remove) - 1);
                if (cur_count.get(remove) == 0) {
                    cur_count.remove(remove);
                }
            }

            while (r < total && cur_count.size() < total_count) {
                cur_count.put(nums[r], cur_count.getOrDefault(nums[r], 0) + 1);
                r++;
            }

            if (cur_count.size() == total_count) {
                ans += total - r + 1;
            }
        }
        return ans;
    }
}