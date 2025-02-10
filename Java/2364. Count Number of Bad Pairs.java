class Solution {
    public long countBadPairs(int[] nums) {
        long bad_pairs = 0;
        Map<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int d = i - nums[i];
            int good_pairs = diff.getOrDefault(d, 0);
            bad_pairs += i - good_pairs;
            diff.put(d, good_pairs + 1);
        }

        return bad_pairs;
    }
}