class Solution {
    public int minPairSum(int[] nums) {
        int[] bucket = new int[100001];
        for (int n: nums) {
            bucket[n]++;
        }

        int ans = 0, l = 0, r = 100000;
        while (l <= r) {
            while (l <= r && bucket[l] == 0) {
                l++;
            }
            while (l <= r && bucket[r] == 0) {
                r--;
            }

            if (l <= r) {
                ans = Math.max(ans, l + r);
                bucket[l]--;
                bucket[r]--;
            }
        }
        return ans;
    }
}