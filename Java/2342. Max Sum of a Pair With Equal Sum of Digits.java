class Solution {
    public int maximumSum(int[] nums) {
        int[] digit_sum = new int[82];
        int ans = -1;

        for (int n: nums) {
            int ds = 0;
            for (int cur = n; cur != 0; cur /= 10) {
                ds += cur % 10;
            }

            if (digit_sum[ds] > 0) {
                ans = Math.max(ans, digit_sum[ds] + n);
            }

            digit_sum[ds] = Math.max(digit_sum[ds], n);
        }    

        return ans;
    }
}