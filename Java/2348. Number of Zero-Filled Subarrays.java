class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, subs = 0;

        for (int n: nums) {
            if (n == 0) {
                subs++;
            } else {
                subs = 0;
            }
            ans += subs;
        }

        return ans;
    }
}