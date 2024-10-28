class Solution {
    public int longestSquareStreak(int[] nums) {
        int ans = 0;
        Set<Integer> uniq = new HashSet<>();
        for (int n: nums) {
            uniq.add(n);
        }

        for (int n: nums) {
            long temp = n;
            int cur = 0;
            while (uniq.contains((int) temp)) {
                cur++;
                if (temp * temp > 1e5) {
                    break;
                }
                temp *= temp;
            }
            ans = Math.max(ans, cur);
        }

        return ans > 1 ? ans : -1;
    }
}