class Solution {
    public int minimumDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            indices.computeIfAbsent(n, k -> new ArrayList<>()).add(i);
            int size = indices.get(n).size();
            if (size >= 3) {
                ans = Math.min(ans, 2 * (indices.get(n).get(size - 1) - indices.get(n).get(size - 3)));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}