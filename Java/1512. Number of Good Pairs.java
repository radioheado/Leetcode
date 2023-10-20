class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] vals = new int[101];
        for (int n: nums) {
            vals[n]++;
        }

        int ans = 0;
        for (int v: vals) {
            if (v > 1) {
                ans += v * (v - 1) / 2;
            }
        }

        return ans;
    }
}