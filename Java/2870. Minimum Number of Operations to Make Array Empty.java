class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n: nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        int ans = 0;
        for (int c: counts.values()) {
            if (c == 1) {
                return -1;
            }
            ans += Math.ceil((double)c / 3);
        }

        return ans;
    }
}