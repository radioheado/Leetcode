class Solution {
    public int findMaxK(int[] nums) {
        int ans = -1;
        Set<Integer> seen = new HashSet<>();

        for (int n: nums) {
            int abs = Math.abs(n);
            if ((abs > ans) && seen.contains(-n)) {
                ans = abs;
            }
            seen.add(n);
        }

        return ans;
    }
}