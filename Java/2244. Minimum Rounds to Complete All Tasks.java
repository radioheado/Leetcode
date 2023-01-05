class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> nums = new HashMap();
        for (int t: tasks) {
            nums.put(t, nums.getOrDefault(t, 0) + 1);
        }

        int ans = 0;
        for (int n: nums.values()) {
            if ( n == 1) {
                return -1;
            } else if (n % 3 == 0) {
                ans += n / 3;
            } else {
                ans += n / 3 + 1;
            }
        }

        return ans;
    }
}