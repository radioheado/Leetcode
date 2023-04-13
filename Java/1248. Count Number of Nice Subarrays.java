class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap();
        count.put(0, 1);
        int odds = 0, ans = 0;

        for (int n: nums) {
            if (n % 2 == 1) {
                odds++;
            }
            if (count.containsKey(odds - k)) {
                ans += count.get(odds - k);
            }
            count.put(odds, count.getOrDefault(odds, 0) + 1);
        }

        return ans;
    }
}