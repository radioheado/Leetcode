class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;

        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
            if (count.containsKey(n - 1)) {
                ans = Math.max(ans, count.get(n) + count.get(n - 1));
            }
            if (count.containsKey(n + 1)) {
                ans = Math.max(ans, count.get(n) + count.get(n + 1));
            }
        }

        return ans;
    }
}