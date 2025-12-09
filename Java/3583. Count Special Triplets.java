class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> totalCount = new HashMap<>();
        for (int n: nums) {
            totalCount.put(n, totalCount.getOrDefault(n, 0) + 1);
        }

        int MOD = 1_000_000_007;
        long ans = 0;
        Map<Integer, Integer> curCount = new HashMap<>();
        for (int n: nums) {
            int target = n * 2;
            int leftCount = curCount.getOrDefault(target, 0);
            curCount.put(n, curCount.getOrDefault(n, 0) + 1);
            int rightCount = totalCount.getOrDefault(target, 0) - curCount.getOrDefault(target, 0);
            ans = (ans + (long) leftCount * rightCount) % MOD;
        }

        return (int) ans;
    }
}