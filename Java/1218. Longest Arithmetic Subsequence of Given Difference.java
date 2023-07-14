class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> dp = new HashMap();
        
        for (int n: arr) {
            dp.put(n, Math.max(dp.getOrDefault(n, 0), 1 + dp.getOrDefault(n - difference, 0)));
            ans = Math.max(ans, dp.get(n));
        }

        return ans;
    }
}