class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> nums = new HashSet();
        for (int b: banned) {
            nums.add(b);
        }

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!nums.contains(i) && maxSum - i >= 0) {
                maxSum -= i;
                ans++;
            }
            if (maxSum <= i) {
                break;
            }
        }

        return ans;
    }
}