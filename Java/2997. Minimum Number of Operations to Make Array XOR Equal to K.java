class Solution {
    public int minOperations(int[] nums, int k) {
        int cur = 0, ans = 0;
        for (int n: nums) {
            cur ^= n;
        }

        while (k > 0 || cur > 0) {
            if (k % 2 != cur % 2) {
                ans++;
            }
            k /= 2;
            cur /= 2;
        }

        return ans;
    }
}