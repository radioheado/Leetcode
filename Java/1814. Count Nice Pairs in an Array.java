class Solution {
    public int countNicePairs(int[] nums) {
        int MOD = (int) Math.pow(10, 9) + 7;
        Map<Integer, Integer> diffs = new HashMap();
        int ans = 0;

        for (int n: nums) {
            int diff = n - rev(n);
            diffs.put(diff, diffs.getOrDefault(diff, 0) + 1);
            ans = (ans + diffs.get(diff) - 1) % MOD;
        }

        return ans;
    }

    private int rev(int num) {
        int ans = 0;
        while (num > 0) {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return ans;
    }
}