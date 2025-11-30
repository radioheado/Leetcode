class Solution {
    public int minSubarray(int[] nums, int p) {
        int total = 0, l = nums.length;
        for (int n: nums) {
            total = (total + n) % p;
        }

        if (total == 0) {
            return 0;
        }

        int ans = l, sum = 0, needed = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, -1);
        
        for (int i = 0; i < l; i++) {
            sum = (sum + nums[i]) % p;
            needed = (sum - total + p) % p;

            if (prefix.containsKey(needed)) {
                ans = Math.min(ans, i - prefix.get(needed));
            }

            prefix.put(sum, i);
        }

        return ans == l ? -1 : ans;
    }
}