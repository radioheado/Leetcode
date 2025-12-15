class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int streak = 0, prev = 0;

        for (int price: prices) {
            if (price == prev - 1) {
                streak++;
            } else {
                streak = 1;
            }
            prev = price;
            ans += (long) streak;
        }

        return ans;
    }
}