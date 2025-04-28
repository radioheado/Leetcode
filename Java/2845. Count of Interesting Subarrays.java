class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int count = 0;
        
        for (int n: nums) {
            count += n % modulo == k ? 1 : 0;
            ans += prefix.getOrDefault((count - k + modulo) % modulo, 0);
            prefix.put(count % modulo, prefix.getOrDefault(count % modulo, 0) + 1);
        }

        return ans;
    }
}