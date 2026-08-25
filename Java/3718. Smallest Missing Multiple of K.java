class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        int ans = k;
        while (set.contains(ans)) {
            ans += k;
        }
        return ans;
    }
}