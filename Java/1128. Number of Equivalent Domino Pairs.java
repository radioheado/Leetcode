class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] nums = new int[100];
        int ans = 0;

        for (int[] d: dominoes) {
            int x = d[0], y = d[1];
            int val = x >= y ? x * 10 + y : y * 10 + x;
            ans += nums[val];
            nums[val]++;
        }

        return ans;
    }
}