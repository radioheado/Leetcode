class Solution {
    public int countValidSelections(int[] nums) {
        int sum = 0, pre = 0, ans = 0;
        for (int n: nums) {
            sum += n;
        }

        for (int n: nums) {
            pre += n;
            if (n == 0) {
                if (pre * 2 == sum) {
                    ans += 2;
                } else if (Math.abs(pre * 2 - sum) == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}